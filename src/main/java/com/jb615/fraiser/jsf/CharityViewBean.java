package com.jb615.fraiser.jsf;

import com.jb615.fraiser.ejb.CharityViewService;
import com.jb615.fraiser.ejb.UserViewService;
import com.jb615.fraiser.ejb.UserService;
import com.jb615.fraiser.entity.Activity;
import com.jb615.fraiser.entity.Cause;
import com.jb615.fraiser.entity.Charity;
import com.jb615.fraiser.entity.Donation;
import com.jb615.fraiser.entity.Fundraiser;
import com.jb615.fraiser.entity.SystemUser;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author jb615
 */
@Named
@RequestScoped
public class CharityViewBean {

    @Inject
    CharityViewService chvsrv;
    
    public Charity getMyUser() {
        return chvsrv.getMyUser();
    }
    
    public List<Cause> getAllMyCauses() {
        return chvsrv.getAllMyCauses();
    }
    
    public int getAmountRaisedForCause(int id) {
        return chvsrv.getAmountRaisedForCause(id);
    }
    
    public List<Activity> getAllActivitiesFromCauseId(int id) {
        return chvsrv.getAllActivitiesFromCauseId(id);
    }
    
    public List<Donation> getAllDonationsFromActivityId(int id) {
        return chvsrv.getAllDonationsFromActivityId(id);
    }
    
    public Cause getCauseById(int id) {
        return chvsrv.getCauseById(id);
    }
    
    public Activity getActivityById(int id) {
        return chvsrv.getActivityById(id);
    }
    
    public CharityViewBean() {
        
    }
    
}
