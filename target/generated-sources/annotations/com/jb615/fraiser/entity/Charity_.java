package com.jb615.fraiser.entity;

import com.jb615.fraiser.entity.Cause;
import com.jb615.fraiser.entity.SystemUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T15:33:14")
@StaticMetamodel(Charity.class)
public class Charity_ { 

    public static volatile SingularAttribute<Charity, String> shortdescription;
    public static volatile SingularAttribute<Charity, String> uniqueName;
    public static volatile SingularAttribute<Charity, String> address;
    public static volatile SingularAttribute<Charity, Integer> balance;
    public static volatile SingularAttribute<Charity, Long> charityid;
    public static volatile ListAttribute<Charity, Cause> causes;
    public static volatile SingularAttribute<Charity, String> charityName;
    public static volatile SingularAttribute<Charity, SystemUser> user;
    public static volatile SingularAttribute<Charity, String> username;

}