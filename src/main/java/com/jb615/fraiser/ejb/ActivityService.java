package com.jb615.fraiser.ejb;

import com.jb615.fraiser.entity.Activity;
import com.jb615.fraiser.entity.Cause;
import com.jb615.fraiser.entity.Charity;
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
@Stateless
public class ActivityService {

    @PersistenceContext
    EntityManager em;

    public ActivityService() {
    }
    
    //registers an activity given a name, description and id
    public void registerActivity(String activityname, String activitydescription, int causeid) {      
        Activity activity = new Activity(activityname, activitydescription);
         
        //get cause and username
        Query query = em.createNamedQuery("findCauseById");
        query.setParameter("causeid", causeid);
        List<Cause> results = query.getResultList();
        Cause cause = results.get(0);
        
        String username;
        username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

        Query query2 = em.createNamedQuery("findUserByUsername");
        query2.setParameter("username", username);
        List<SystemUser> results2 = query2.getResultList();
        SystemUser user = results2.get(0);
        Fundraiser fund = user.getFundraiser();
        
        //linking the fundraiser and the activity
        fund.addActivity(activity);
        cause.addActivity(activity);
        em.persist(activity);
    }

}
