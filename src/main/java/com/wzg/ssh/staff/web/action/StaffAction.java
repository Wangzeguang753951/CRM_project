package com.wzg.ssh.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.wzg.ssh.base.BaseAction;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.department.service.DeptService;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import com.wzg.ssh.staff.service.StaffService;
import com.wzg.ssh.utils.MD5Util;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public class StaffAction extends BaseAction<Staff, StaffService> {


    private List<Department> deptList;
    private List<Staff> listStaff;
    private List<Department> departments;
    private List<Post> postList;


    // 引用deptService对象 在员工中执行查询所有部门和职位等方法
    private DeptService deptService;


    private List<Staff> staffs;

    // 修改密码的 三个属性 接收一下
    private String newPassword;
    private String reNewPassword;
    private String oldPassword;


    // 登录方法
    public String login() {

        // 做登录验证
        // 将Staff对象的姓名属性和 对象放到session里面
        // 修改密码时候根据对象取到登录密码 进行修改
        Staff staff = service.login(getModel());
        if (staff != null) {
            sessionPut("login", staff.getStaffName());
            sessionPut("staff", staff);
            return SUCCESS;
        }
        addActionError("密码不匹配噢!!");
        return INPUT;

    }

    @SkipValidation
    // 重新登录 要清楚session中的数据
    public String reLogin() {

        sessionRemove("login");
        return SUCCESS;

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
        if (getModel().getLoginName().equals("") ||
                getModel().getLoginPwd().equals("") ||
                getModel().getGender().equals("") ||
                getModel().getPost().getPostId() < 0 ||
                getModel().getOnDutyDate().equals("")) {
            addActionError("不能有空的选项哦!!");
            departments = service.getDept();
            return INPUT;

        }
        String md5 = MD5Util.getMd5(getModel().getLoginPwd());
        System.out.println(md5);
        getModel().setLoginPwd(md5);
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }


    @SkipValidation
    public String getDept() {
        departments = service.getDept();
        postList = deptService.getPostByDeptId(getModel().getPost().getDept());
        return SUCCESS;
    }

    // 点击高级查询
    @SkipValidation
    public String getAllResult() {
        System.out.println(getModel().getStaffName());
        staffs = service.getAllResult(getModel().getPost().getDept().getDeptId(), getModel().getPost().getPostId(), getModel().getStaffName());
        return SUCCESS;

    }


    @SkipValidation
    //编辑时候根据职位ID查出所有员工
    public String getStaffsByStaffId() {
        staffs = service.getStaffsByStaffId(getModel());
        sessionPut("staffsss", staffs.get(0));
        departments = service.getDept();
        return SUCCESS;
    }

    @SkipValidation
    // 修改密码
    public String updatePwd() {
        // 获取要修改密码的对象
        Staff staff = (Staff) ActionContext.getContext().getSession().get("staff");

        // 进行验证
        // 并且加密
        if (!reNewPassword.equals(newPassword)) {
            addActionError("密码填写不一致哦!!");
            return INPUT;
        } else if (oldPassword.equals("")) {
            addActionError("请填写原始密码");
            return INPUT;
        } else if (newPassword.equals("")) {
            addActionError("请填写新密码");
            return INPUT;
        }

        staff.setLoginPwd(MD5Util.getMd5(newPassword));
        service.saveOrUpdate(staff);
        return SUCCESS;
    }


//    // 分页查询
//    public String QueryByPages() {
//
//        return SUCCESS;
//    }


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

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
