package com.jb615.fraiser.jsf;
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
public class CharityRegBean {

    @EJB
    UserService usrSrv;
    
    String username;
    String charityname;
    String userpassword;
    String uniquename;  

    String address;
    String shortdescription;
    double balance;

    public CharityRegBean() {
    }

    public CharityRegBean(UserService usrSrv, String username, String charityname, String userpassword, String uniquename, String address, String shortdescription, double balance) {
        this.usrSrv = usrSrv;
        this.username = username;
        this.charityname = charityname;
        this.userpassword = userpassword;
        this.uniquename = uniquename;
        this.address = address;
        this.shortdescription = shortdescription;
        this.balance = balance;
    }

    //call the injected EJB
    public String register() {
        //usrSrv.registerUser(username, userpassword);
        usrSrv.registerCharity(username, userpassword, charityname, uniquename, address, shortdescription);
        return "index";
    }

    public UserService getUsrSrv() {
        return usrSrv;
    }

    public void setUsrSrv(UserService usrSrv) {
        this.usrSrv = usrSrv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUniquename() {
        return uniquename;
    }

    public void setUniquename(String uniquename) {
        this.uniquename = uniquename;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCharityname() {
        return charityname;
    }

    public void setCharityname(String charityname) {
        this.charityname = charityname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
}
