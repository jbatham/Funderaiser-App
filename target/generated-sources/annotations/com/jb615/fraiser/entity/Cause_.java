package com.jb615.fraiser.entity;

import com.jb615.fraiser.entity.Activity;
import com.jb615.fraiser.entity.Charity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-25T15:33:14")
@StaticMetamodel(Cause.class)
public class Cause_ { 

    public static volatile SingularAttribute<Cause, Long> causeid;
    public static volatile SingularAttribute<Cause, String> causedescription;
    public static volatile SingularAttribute<Cause, Charity> charity;
    public static volatile SingularAttribute<Cause, String> causename;
    public static volatile ListAttribute<Cause, Activity> activities;

}