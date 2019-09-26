package com.jb615.fraiser.ejb;

import com.jb615.fraiser.entity.Activity;
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
//function to deal with user based views
@Stateless
public class UserViewService {

    @PersistenceContext
    EntityManager em;

    public UserViewService() {
    }

    //function to return a list of all the users
    public List<SystemUser> getAllUsers() {
        List<SystemUser> users = em.createNamedQuery("findAllUsers").getResultList();
        return users;
    }

    //function to get all the funraiser users
    public List<Fundraiser> getFundraiserUsers() {
        List<Fundraiser> users = em.createNamedQuery("findFundraisers").getResultList();
        return users;
    }

    //function to get a fundraiser account given an id
    public Fundraiser getFundraiserById(int id) {
        Query query = em.createNamedQuery("findFundraiserById");
        query.setParameter("id", id);
        List<Fundraiser> results = query.getResultList();
        Fundraiser result = results.get(0);
        return result;
    }

    //function to get the current user
    public Fundraiser getMyUser() {
        String username;
        username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        
        Query query = em.createNamedQuery("findUserByUsername");
        query.setParameter("username", username);
        List<SystemUser> results = query.getResultList();
        SystemUser user = results.get(0);
        Fundraiser fund = user.getFundraiser();
        return fund;
    }
    
    //function to get all activities from the current users account
    public List<Activity> getAllMyActivities() {
        Fundraiser fund = getMyUser();
        return fund.getActivities();
    }
    
    //function to get all activities from any user given an id
    public List<Activity> getAllActivitiesFromUserId(int id) {
        Query query = em.createNamedQuery("findFundraiserById");
        query.setParameter("id", id);
        List<Fundraiser> results = query.getResultList();
        Fundraiser fund = results.get(0);
        
        return fund.getActivities();
    }
    
    //function to get all donations for a specific activity
    public List<Donation> getAllDonationsFromActivityId(int id) {
        System.out.println("THE ID IS"+ id);
        Query query = em.createNamedQuery("findActivityById");
        query.setParameter("id", id);
        List<Activity> results = query.getResultList();
        System.out.println("size of donations list" + results.size());
        Activity act = results.get(0);
        
        return act.getDonations();
    }
    
    
}
