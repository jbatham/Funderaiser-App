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
//class to deal with charity views
@Stateless
public class CharityViewService {

    @PersistenceContext
    EntityManager em;

    public CharityViewService() {
    }
    
    //function to return the current charity user
    public Charity getMyUser() {
        String username;
        username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        
        Query query = em.createNamedQuery("findUserByUsername");
        query.setParameter("username", username);
        List<SystemUser> results = query.getResultList();
        SystemUser user = results.get(0);
        Charity charity = user.getCharity();
        return charity;
    }
    
    //function to get all activities from a given cause id
    public List<Activity> getAllActivitiesFromCauseId(int id) {
        Cause cause = getCauseById(id);
        return cause.getActivities();
    }
    
    //function to get all donations given an activity id
    public List<Donation> getAllDonationsFromActivityId(int id) {
        Activity activity = getActivityById(id);
        return activity.getDonations();
    }
    
    //function to get all the causes for the current user
    public List<Cause> getAllMyCauses() {
        Charity charity = getMyUser();
        return charity.getCauses();
    }
    
    //function to get a cause by id
    public Cause getCauseById(int id) {
        Query query = em.createNamedQuery("findCauseById");
        query.setParameter("causeid", id);
        List<Cause> results = query.getResultList();
        Cause cause = results.get(0);
        return cause;
    }
    
    //function to get an activity given an activity id
    public Activity getActivityById(int id) {
        Query query = em.createNamedQuery("findActivityById");
        query.setParameter("id", id);
        List<Activity> results = query.getResultList();
        Activity activity = results.get(0);
        return activity;
    }
    
    //function to get the amount raised for a specific cause
    public int getAmountRaisedForCause(int id) {
        Query query = em.createNamedQuery("findCauseById");
        query.setParameter("causeid", id);
        List<Cause> results = query.getResultList();
        Cause cause = results.get(0);
        
        List<Activity> activitylist = cause.getActivities();
        int sum = 0;
        for (Activity a: activitylist) {
            List<Donation> donations = a.getDonations();
            for (Donation d: donations) {
                sum = (int) (sum + d.getAmount());
            }
        }
        return sum;
    }
}
