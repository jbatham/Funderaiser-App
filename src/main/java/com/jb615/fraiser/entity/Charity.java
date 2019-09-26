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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jb615
 */
@Entity
@Table(name="CHARITY")
public class Charity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long charityid;
    
    // here on could use Bean Validation annotations to enforce specific rules - this could be alternatively implemented when validating the form in the web tier
    // for now we check only for Null values
    @NotNull
    private String username;    
    @NotNull
    private String charityName;
    @NotNull
    private String uniqueName;

    //@NotNull
    //@Temporal(javax.persistence.TemporalType.DATE)
    //private String dateofestablishment;
    
    @NotNull
    private String address;
    @NotNull
    private String shortdescription;
    @NotNull
    private int balance;
    
    @OneToOne(mappedBy = "charity")
    SystemUser user;
    
    @OneToMany(
        mappedBy = "charity", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Cause> causes = new ArrayList<>();
 
    public void addCause(Cause cause) {
        causes.add(cause);
        cause.setCharity(this);
    }
 
    public void removeCause(Cause cause) {
        causes.remove(cause);
        cause.setCharity(null);
    }

    public Charity(String username, String charityName, String uniqueName, String address, String shortdescription) {
        this.username = username;
        this.charityName = charityName;
        this.uniqueName = uniqueName;
        this.address = address;
        this.shortdescription = shortdescription;
    }

    public Charity() {
    }
    
    public Long getCharityid() {
        return charityid;
    }

    public void setCharityid(Long charityid) {
        this.charityid = charityid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
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
        hash = 97 * hash + Objects.hashCode(this.charityid);
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.charityName);
        hash = 97 * hash + Objects.hashCode(this.uniqueName);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.shortdescription);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
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
        final Charity other = (Charity) obj;
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.charityName, other.charityName)) {
            return false;
        }
        if (!Objects.equals(this.uniqueName, other.uniqueName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.shortdescription, other.shortdescription)) {
            return false;
        }
        if (!Objects.equals(this.charityid, other.charityid)) {
            return false;
        }
        return true;
    }

    
    
    
   
}
