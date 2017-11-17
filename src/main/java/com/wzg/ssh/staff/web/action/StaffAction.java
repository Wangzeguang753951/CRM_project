package com.wzg.ssh.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.wzg.ssh.base.BaseAction;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.department.service.DeptService;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import com.wzg.ssh.staff.service.StaffService;
import com.wzg.ssh.utils.MD5Util;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public class StaffAction extends BaseAction<Staff, StaffService> {
    private List<Staff> listStaff;
    private List<Department> departments;
    private List<Post> postList;

    // 引用deptService对象 在员工中执行查询所有部门和职位等方法
    private DeptService deptService;
    private List<Department> deptList;
    private List<Staff> staffByDeptIdList;
    private List<Staff> staffs;


    // 登录方法
    public String login() {
        Staff staff = service.login(getModel());
        if (staff != null) {
            sessionPut("login", staff.getStaffName());
            return SUCCESS;
        }
        return INPUT;
    }


    // 查出所有的员工 点击员工管理
    // 并且显示二级联动可以好用

    @SkipValidation
    public String getStaff() {

        // 查出所有的员工


        deptList = deptService.getDept();
        listStaff = service.getStaff(getModel());


        return SUCCESS;
    }



    // 保存或者更新员工
    @SkipValidation
    public String saveOrUpdateStaff() {
        String md5 = MD5Util.getMd5(getModel().getLoginPwd());
        System.out.println(md5);
        getModel().setLoginPwd(md5);
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }


    @SkipValidation
    public String getDept() {

        departments = service.getDept();
        departments.forEach(System.out::println);
        postList = deptService.getPostByDeptId(getModel().getPost().getDept());

        return SUCCESS;
    }

    @SkipValidation
    public String getAllResult() {
        System.out.println(getModel().getStaffName());
        staffs = service.getAllResult(getModel().getPost().getDept().getDeptId(),getModel().getPost().getPostId(),getModel().getStaffName());
        return SUCCESS;
    }

    @SkipValidation
    public String QueryByPages(){

        return SUCCESS;
    }


    public List<Staff> getListStaff() {
        return listStaff;
    }

    public void setListStaff(List<Staff> listStaff) {
        this.listStaff = listStaff;
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

    //为了在Spring中使用deptService对象 要提供set方法
    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }

    public List<Staff> getStaffByDeptIdList() {
        return staffByDeptIdList;
    }

    public void setStaffByDeptIdList(List<Staff> staffByDeptIdList) {
        this.staffByDeptIdList = staffByDeptIdList;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
