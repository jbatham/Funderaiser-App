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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb615
 */
@Stateless
public class ListActivityService {

    @PersistenceContext
    EntityManager em;

    public ListActivityService() {
    }
    
    //function to list all activities 
    public List<Activity> getAllActivities() {
        List<Activity> activities = em.createNamedQuery("findAllActivities").getResultList();
        return activities;
    }

}
