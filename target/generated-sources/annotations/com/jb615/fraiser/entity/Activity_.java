package com.jb615.fraiser.entity;

import com.jb615.fraiser.entity.Cause;
import com.jb615.fraiser.entity.Donation;
import com.jb615.fraiser.entity.Fundraiser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T15:33:14")
@StaticMetamodel(Activity.class)
public class Activity_ { 

    public static volatile SingularAttribute<Activity, Fundraiser> fundraiser;
    public static volatile SingularAttribute<Activity, String> activitydescription;
    public static volatile ListAttribute<Activity, Donation> donations;
    public static volatile SingularAttribute<Activity, Cause> cause;
    public static volatile SingularAttribute<Activity, Long> id;
    public static volatile SingularAttribute<Activity, String> activityname;

}