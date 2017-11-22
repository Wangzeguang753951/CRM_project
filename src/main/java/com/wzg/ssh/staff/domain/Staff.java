package com.wzg.ssh.staff.domain;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;

/**
 * Created by dllo on 17/11/9.
 */
public class Staff {
    private int staffId;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private String onDutyDate;





    // 员工对应多个职位
    private Post post;

    // 员工对应多个部门

    private Department dept;


    public Staff(String staffName, Post post) {
        this.staffName = staffName;
        this.post = post;
    }

    public Staff() {
    }

    public Staff(String loginName, String loginPwd, String staffName, String gender, String onDutyDate) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;

    }

    public Staff(int staffId, String loginName, String loginPwd, String staffName, String gender, String onDutyDate) {
        this.staffId = staffId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate='" + onDutyDate + '\'' +
                '}';
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {

        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {

        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(String onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Staff(String staffName) {
        this.staffName = staffName;
    }



}
