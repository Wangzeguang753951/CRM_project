package com.wzg.ssh.staff.web.action;

import com.wzg.ssh.base.BaseAction;
import com.wzg.ssh.staff.domain.Department;
import com.wzg.ssh.staff.service.StaffService;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptAction extends BaseAction<Department,StaffService> {

    public String saveDept(){
        Department dept = service.saveDept(getModel());
        sessionPut("dept",dept);
        return SUCCESS;
    }

}
