package com.wzg.ssh.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.wzg.ssh.base.BaseAction;
import com.wzg.ssh.staff.domain.Staff;
import com.wzg.ssh.staff.service.StaffService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by dllo on 17/11/9.
 */

public class StaffAction extends BaseAction<Staff,StaffService>{
   // 登录方法
    public String login(){
        Staff staff = service.login(getModel());
        if (staff != null) {
            sessionPut("login", staff.getLoginName());
            return SUCCESS;
        }
        return INPUT;
    }


    // 向数据库中插入员工
    public String saveStaff(){
       service.saveStaff(getModel());
        return SUCCESS;
    }














}
