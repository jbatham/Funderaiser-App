package com.jb615.fraiser.entity;

import com.jb615.fraiser.entity.Charity;
import com.jb615.fraiser.entity.Fundraiser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T15:33:14")
@StaticMetamodel(SystemUser.class)
public class SystemUser_ { 

    public static volatile SingularAttribute<SystemUser, Fundraiser> fundraiser;
    public static volatile SingularAttribute<SystemUser, Charity> charity;
    public static volatile SingularAttribute<SystemUser, Long> id;
    public static volatile SingularAttribute<SystemUser, String> username;
    public static volatile SingularAttribute<SystemUser, String> userpassword;

}