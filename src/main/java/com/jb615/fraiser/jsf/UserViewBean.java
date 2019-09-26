package com.jb615.fraiser.jsf;

import com.jb615.fraiser.ejb.UserViewService;
import com.jb615.fraiser.ejb.UserService;
import com.jb615.fraiser.entity.Activity;
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
public class UserViewBean {

    @Inject
    UserViewService test;
    
    //Call EJB to get all users
    public List<SystemUser> getAllUsers() {
        return test.getAllUsers();
    }
    
    //Call EJB to get users that are fundraisers
    public List<Fundraiser> getFundraiserUsers() {
        return test.getFundraiserUsers();
    }
    
    //Call EJB to get fundraiser by their id
    public Fundraiser getFundraiserById(int id) {
        return test.getFundraiserById(id);
    }
    
    //Call EJB to return current user
    public Fundraiser getMyUser() {
        return test.getMyUser();
    }
    
    //Call EJB to get a list of activities for current user
    public List<Activity> getAllMyActivities() {
        return test.getAllMyActivities();
    }
    
    //Call EJB to get a list of activities for a specific id
    public List<Donation> getAllDonationsFromActivityId(int id) {
        return test.getAllDonationsFromActivityId(id);
    }
    
    //Call EJB to get a list of activities for a specific user
    public List<Activity> getAllActivitiesFromUserId(int id) {
        return test.getAllActivitiesFromUserId(id);
    }
    
    
    public UserViewBean() {
    }
    
}
