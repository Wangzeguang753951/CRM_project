package com.wzg.ssh.staff.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wzg.ssh.staff.domain.Staff;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffInterceptor extends  MethodFilterInterceptor{

    // 登录拦截
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        String login = (String) ActionContext.getContext().getSession().get("login");
        if (login==null){
            ActionContext.getContext().getSession().put("key","您还没有登录哦!!!");
            return "interceptor";
        }
        return actionInvocation.invoke();



    }
}
