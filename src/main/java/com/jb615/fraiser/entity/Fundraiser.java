package com.jb615.fraiser.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jb615
 */


@NamedQueries({
    @NamedQuery(name = "findFundraisers", query = "SELECT c FROM Fundraiser c"),
    @NamedQuery(name = "findFundraiserById", query = "SELECT c FROM Fundraiser c WHERE c.id = :id"),
})

@Entity
public class Fundraiser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // here on could use Bean Validation annotations to enforce specific rules - this could be alternatively implemented when validating the form in the web tier
    // for now we check only for Null values
    @NotNull
    String username;

    @NotNull
    String name;
   
    @NotNull
    String bio;
    
    @NotNull
    int balance;
    
    @OneToOne(mappedBy = "fundraiser")
    SystemUser user;
    
    @OneToMany(
        mappedBy = "fundraiser", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Activity> activities = new ArrayList<>();
 
    public void addActivity(Activity activity) {
        activities.add(activity);
        activity.setFundraiser(this);
    }
 
    public void removeActivity(Activity activity) {
        activities.remove(activity);
        activity.setFundraiser(null);
    }
    
    public Fundraiser(String username, String name, String bio) {
        this.username = username;
        this.name = name;
        this.bio = bio;
    }

    public Fundraiser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return username;
    }

    public void setFirstname(String firstname) {
        this.username = firstname;
    }

    public String getLastname() {
        return name;
    }

    public void setLastname(String lastname) {
        this.name = lastname;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.bio);
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
        final Fundraiser other = (Fundraiser) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.bio, other.bio)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
