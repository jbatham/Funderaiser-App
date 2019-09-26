package com.jb615.fraiser.ejb;

import com.jb615.fraiser.entity.Cause;
import com.jb615.fraiser.entity.Charity;
import com.jb615.fraiser.entity.Fundraiser;
import com.jb615.fraiser.entity.SystemUser;
import com.jb615.fraiser.entity.SystemUserGroup;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.log;
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
import javax.persistence.TypedQuery;

/**
 *
 * @author jb615
 */
@Stateless
public class CauseService {

    @PersistenceContext
    EntityManager em;

    public CauseService() {
    }
    
    //registers a cause given a name and description
    public void registerCause(String causename, String causedescription) {
        
        //get current user
        String username;
        username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();

        Query query = em.createNamedQuery("findUserByUsername");
        query.setParameter("username", username);
        List<SystemUser> results = query.getResultList();
        SystemUser user = results.get(0);
        Charity charity = user.getCharity();
        
        //link cause and user together
        Cause cause = new Cause(causename, causedescription);
        charity.addCause(cause);
        em.persist(cause);
    }

}
