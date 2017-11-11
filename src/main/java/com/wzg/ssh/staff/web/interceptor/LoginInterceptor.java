package com.wzg.ssh.staff.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wzg.ssh.staff.domain.Staff;

/**
 * Created by dllo on 17/11/10.
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    // 登录拦截

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Staff login = (Staff) ActionContext.getContext().getSession().get("login");

        if (login==null){

            return "input";

        }
        return actionInvocation.invoke();


    }
}
