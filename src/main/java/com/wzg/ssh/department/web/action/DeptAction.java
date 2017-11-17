package com.wzg.ssh.department.web.action;

import com.wzg.ssh.base.BaseAction;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.department.service.DeptService;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public class DeptAction extends BaseAction<Department, DeptService> {

    //查出的所有部门的集合
    private List<Department> departments;


    private List<Post> postList;

    private List<Staff> listStaff;


    // 保存部门
    public String saveOrUpdateDept() {
        System.out.println(getModel().getDeptName());
    ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        service.saveOrUpdateDept(getModel());

        return SUCCESS;
    }


    // 查出所有部门 结果为departments集合
    public String getDept() {
            departments = service.getDept();
            return SUCCESS;


    }


    //    根据部门ID查询所有职位
    public String getPostByDeptId() {
        postList = service.getPostByDeptId(getModel());
        return SUCCESS;
    }


    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Staff> getStaffs() {
        return listStaff;
    }

    public void setStaffs(List<Staff> staffs) {
        this.listStaff = staffs;
    }
}
