package com.jb615.fraiser.jsf;
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
public class CauseRegBean {

    @EJB
    CauseService causeSrv;
    
    String causename;
    String causedescription;
    int charityid;  


    public CauseRegBean() {
    }

    public CauseRegBean(String causename, String causedescription) {
        this.causename = causename;
        this.causedescription = causedescription;
    }

    //call the injected EJB
    public String registerCause() {
        causeSrv.registerCause(causename, causedescription);
        //usrSrv.registerCharity(username, userpassword, charityname, uniquename, address, shortdescription);
        return "index";
    }

    public CauseService getCauseSrv() {
        return causeSrv;
    }

    public void setCauseSrv(CauseService causeSrv) {
        this.causeSrv = causeSrv;
    }

    public String getCausename() {
        return causename;
    }

    public void setCausename(String causename) {
        this.causename = causename;
    }

    public String getCausedescription() {
        return causedescription;
    }

    public void setCausedescription(String causedescription) {
        this.causedescription = causedescription;
    }

    public int getCharityid() {
        return charityid;
    }

    public void setCharityid(int charityid) {
        this.charityid = charityid;
    }
    
}
