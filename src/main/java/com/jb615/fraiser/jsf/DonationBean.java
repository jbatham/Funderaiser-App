package com.jb615.fraiser.jsf;
import com.jb615.fraiser.ejb.ActivityService;
import com.jb615.fraiser.ejb.CauseService;
import com.jb615.fraiser.ejb.DonationService;
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
public class DonationBean {
    @EJB
    DonationService donateSrv;
    
    int activityid;
    int amount;

    public DonationBean() {
    }

    public DonationBean(DonationService donateSrv, int activityid, int amount) {
        this.donateSrv = donateSrv;
        this.activityid = activityid;
        this.amount = amount;
    }

    //call the injected EJB
    public void Donate() {
        donateSrv.donate(activityid, amount);
    }

    public DonationService getDonateSrv() {
        return donateSrv;
    }

    public void setDonateSrv(DonationService donateSrv) {
        this.donateSrv = donateSrv;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}
