package com.jb615.fraiser.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jb615
 */

@NamedQueries({
    @NamedQuery(name="findAllActivities", query="SELECT c FROM Activity c"),
    @NamedQuery(name = "findActivityById", query = "SELECT c FROM Activity c WHERE c.id = :id")
})
@Entity
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    String activityname;

    @NotNull
    String activitydescription;  
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "causeid")
    private Cause cause;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fundraiserid")
    private Fundraiser fundraiser;
    
    @OneToMany(
            mappedBy = "activity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Donation> donations = new ArrayList<>();

    //Constructors, getters and setters removed for brevity
    public void addDonation(Donation donation) {
        donations.add(donation);
        donation.setActivity(this);
    }

    public void removeDonation(Donation donation) {
        donations.remove(donation);
        donation.setActivity(null);
    }
    
    public Activity(String activityname, String activitydescription) {
        this.activityname = activityname;
        this.activitydescription = activitydescription;
    }

    public Activity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getActivitydescription() {
        return activitydescription;
    }

    public void setActivitydescription(String activitydescription) {
        this.activitydescription = activitydescription;
    }

    public Fundraiser getFundraiser() {
        return fundraiser;
    }

    public void setFundraiser(Fundraiser fundraiser) {
        this.fundraiser = fundraiser;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.activityname);
        hash = 97 * hash + Objects.hashCode(this.activitydescription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Activity other = (Activity) obj;
        if (!Objects.equals(this.activityname, other.activityname)) {
            return false;
        }
        if (!Objects.equals(this.activitydescription, other.activitydescription)) {
            return false;
        }
        return true;
    }

    public Cause getCause() {
        return cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }
     
    
}
