package com.jb615.fraiser.entity;

import com.jb615.fraiser.entity.Activity;
import com.jb615.fraiser.entity.Fundraiser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T15:33:14")
@StaticMetamodel(Donation.class)
public class Donation_ { 

    public static volatile SingularAttribute<Donation, Integer> amount;
    public static volatile SingularAttribute<Donation, Activity> activity;
    public static volatile SingularAttribute<Donation, Long> donationid;
    public static volatile SingularAttribute<Donation, Fundraiser> donator;
    public static volatile SingularAttribute<Donation, Date> dateofdonation;

}