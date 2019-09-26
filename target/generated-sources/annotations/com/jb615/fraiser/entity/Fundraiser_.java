package com.jb615.fraiser.entity;

import com.jb615.fraiser.entity.Activity;
import com.jb615.fraiser.entity.SystemUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T15:33:14")
@StaticMetamodel(Fundraiser.class)
public class Fundraiser_ { 

    public static volatile SingularAttribute<Fundraiser, Integer> balance;
    public static volatile ListAttribute<Fundraiser, Activity> activities;
    public static volatile SingularAttribute<Fundraiser, String> name;
    public static volatile SingularAttribute<Fundraiser, String> bio;
    public static volatile SingularAttribute<Fundraiser, Long> id;
    public static volatile SingularAttribute<Fundraiser, SystemUser> user;
    public static volatile SingularAttribute<Fundraiser, String> username;

}