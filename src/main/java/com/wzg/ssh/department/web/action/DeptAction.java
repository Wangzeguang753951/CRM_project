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
//    private String totalPage;
//    private String pageSize;
//    private String offSet;
//    private int totalSize;



    //查出的所有部门的集合
    private List<Department> departments;

    // 所有职位集合
    private List<Post> postList;

    // 所有员工的集合
    private List<Staff> listStaff;


    //  查出所有部门 结果为departments集合
    @SkipValidation
    public String getDept() {
        departments = service.getDept();
        return SUCCESS;
    }


    // 保存或者编辑部门
    public String saveOrUpdateDept() {

        // 给出验证判断
        if (!getModel().getDeptName().equals("")) {
            service.saveOrUpdateDept(getModel());
            return SUCCESS;
        }
        // 走验证器
        return INPUT;


    }


    @SkipValidation
    //    根据部门ID查询所有职位
    public String getPostByDeptId() {
        postList = service.getPostByDeptId(getModel());
        return SUCCESS;
    }
//    @SkipValidation
//    public String listByPage(){
//        List<Department> dept = service.getDept();
//        totalSize = dept.size();
//
//        return SUCCESS;
//    }


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

//    public String getTotalPage() {
//        return totalPage;
//    }
//
//    public void setTotalPage(String totalPage) {
//        this.totalPage = totalPage;
//    }
//
//    public String getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(String pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public String getOffSet() {
//        return offSet;
//    }
//
//    public void setOffSet(String offSet) {
//        this.offSet = offSet;
//    }

//    public String getTotalSize() {
//        return totalSize;
//    }
//
//    public void setTotalSize(String totalSize) {
//        this.totalSize = totalSize;
//    }
}
