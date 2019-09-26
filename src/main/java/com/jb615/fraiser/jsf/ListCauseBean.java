package com.jb615.fraiser.jsf;

import com.jb615.fraiser.ejb.ListCauseService;
import com.jb615.fraiser.ejb.UserViewService;
import com.jb615.fraiser.ejb.UserService;
import com.jb615.fraiser.entity.Cause;
import com.jb615.fraiser.entity.SystemUser;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jb615
 */
@Named
@RequestScoped
public class ListCauseBean {

    @Inject
    ListCauseService listcause;

    public List<Cause> getAllCauses() {
        return listcause.getAllCauses();
    }
    
    public ListCauseBean() {
    }
    
}
