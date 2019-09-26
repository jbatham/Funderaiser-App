package com.jb615.fraiser.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jb615
 */
@Entity
public class Donation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long donationid;

    @NotNull
    int amount;
    
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateofdonation;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activityid")
    private Activity activity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fundraiser")
    private Fundraiser donator;
    
    
    public Donation() {
        
    }

    public Donation(int donationamount) {
        this.amount = donationamount;
        this.dateofdonation = new Date();
    }

    public Long getDonationid() {
        return donationid;
    }

    public void setDonationid(Long donationid) {
        this.donationid = donationid;
    }

    public Fundraiser getDonator() {
        return donator;
    }

    public void setDonator(Fundraiser donator) {
        this.donator = donator;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDateofdonation() {
        return dateofdonation;
    }

    public void setDateofdonation(Date dateofdonation) {
        this.dateofdonation = dateofdonation;
    }


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.donationid);
        hash = 97 * hash + Objects.hashCode(this.amount);
        hash = 97 * hash + Objects.hashCode(this.dateofdonation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Donation other = (Donation) obj;
        if (!Objects.equals(this.donationid, other.donationid)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.dateofdonation, other.dateofdonation)) {
            return false;
        }
        return true;
    }

}
