package com.jb615.fraiser.jsf;
import com.jb615.fraiser.ejb.ActivityService;
import com.jb615.fraiser.ejb.CauseService;
import java.util.Date;
import com.jb615.fraiser.ejb.UserService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jb615
 */
@Named
@RequestScoped
public class ActivityRegBean {

    @EJB
    ActivityService actSrv;
    
    String activityname;
    String activitydescription;
    int causeid;  


    public ActivityRegBean() {
    }

    //call the injected EJB
    public void registerActivity() {
        actSrv.registerActivity(activityname, activitydescription, causeid);
    }

    public ActivityService getActSrv() {
        return actSrv;
    }

    public void setActSrv(ActivityService actSrv) {
        this.actSrv = actSrv;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getActivitydescription() {
        return activitydescription;
    }

    public void setActivitydescription(String activitydescription) {
        this.activitydescription = activitydescription;
    }

    public int getCauseid() {
        return causeid;
    }

    public void setCauseid(int causeid) {
        this.causeid = causeid;
    }
    
}
