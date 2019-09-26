package com.jb615.fraiser.ejb;

import com.jb615.fraiser.entity.Activity;
import com.jb615.fraiser.entity.Cause;
import com.jb615.fraiser.entity.Charity;
import com.jb615.fraiser.entity.Donation;
import com.jb615.fraiser.entity.Fundraiser;
import com.jb615.fraiser.entity.SystemUser;
import com.jb615.fraiser.entity.SystemUserGroup;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jb615
 */
//class to deal with a donation being placed
@Stateless
public class DonationService {

    @PersistenceContext
    EntityManager em;

    public DonationService() {
    }
    
    //function to deal with entire donation process
    public void donate(int activityid, int amount) { 
        Donation donation = new Donation(amount);
        
        //get the activity from what the user entered
        Query query = em.createNamedQuery("findActivityById");
        query.setParameter("id", activityid);
        List<Activity> results = query.getResultList();
        Activity activity = results.get(0);
        
        //get user and fundraiser instances
        String username;
        username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        Query query2 = em.createNamedQuery("findUserByUsername");
        query2.setParameter("username", username);
        List<SystemUser> results2 = query2.getResultList();
        SystemUser user = results2.get(0);
        Fundraiser fund = user.getFundraiser();
        
        //link donator and activity
        donation.setActivity(activity);
        donation.setDonator(fund);
        
        //if user has the right amount of balance
        if (fund.getBalance() >= amount) {
           
            Charity charity;
            charity = activity.getCause().getCharity();

            
            charity.setBalance(charity.getBalance() + amount);
            fund.setBalance(fund.getBalance() - amount);
            em.persist(donation);
        }
    }

}
