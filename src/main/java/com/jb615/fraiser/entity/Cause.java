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
    @NamedQuery(name="findAllCauses", query="SELECT c FROM Cause c"),
    @NamedQuery(name = "findCauseById", query = "SELECT c FROM Cause c WHERE c.causeid = :causeid")
})


@Entity
public class Cause implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long causeid;

    // here on could use Bean Validation annotations to enforce specific rules - this could be alternatively implemented when validating the form in the web tier
    // for now we check only for Null values
    @NotNull
    String causename;

    @NotNull
    String causedescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charityid")
    private Charity charity;

    @OneToMany(
            mappedBy = "cause",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Activity> activities = new ArrayList<>();

    //Constructors, getters and setters removed for brevity
    public void addActivity(Activity activity) {
        activities.add(activity);
        activity.setCause(this);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
        activity.setCause(null);
    }

    public Cause(String causename, String causedescription) {
        this.causename = causename;
        this.causedescription = causedescription;
    }

    public Cause() {
    }

    public Long getCauseid() {
        return causeid;
    }

    public void setCauseid(Long causeid) {
        this.causeid = causeid;
    }

    public String getCausename() {
        return causename;
    }

    public void setCausename(String causename) {
        this.causename = causename;
    }

    public String getCausedescription() {
        return causedescription;
    }

    public void setCausedescription(String causedescription) {
        this.causedescription = causedescription;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.causeid);
        hash = 41 * hash + Objects.hashCode(this.causename);
        hash = 41 * hash + Objects.hashCode(this.causedescription);
        return hash;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
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
        final Cause other = (Cause) obj;
        if (!Objects.equals(this.causename, other.causename)) {
            return false;
        }
        if (!Objects.equals(this.causedescription, other.causedescription)) {
            return false;
        }
        if (!Objects.equals(this.causeid, other.causeid)) {
            return false;
        }
        return true;
    }

}
