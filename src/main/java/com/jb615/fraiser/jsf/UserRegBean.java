package com.jb615.fraiser.jsf;

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
public class UserRegBean {

    @EJB
    UserService usrSrv;
    
    String username;
    String userpassword;
    String name;
    String bio;
    double balance;

    public UserRegBean() {
    }

    //call the injected EJB
    public String register() {
        //usrSrv.registerUser(username, userpassword);
        usrSrv.registerFundraiser(username, userpassword,name, bio);
        return "index";
    }
    
    public String registerAdmin() {
        usrSrv.registerAdmin(username, userpassword);
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
