package com.wzg.ssh.staff.domain;

/**
 * Created by dllo on 17/11/9.
 */
public class Staff {
    private int id;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private String onDutyDate;


    // 员工对应多个职位
    private Post post;

    // 员工对应多个部门

    private Department dept;




    public Staff() {
    }

    public Staff(String loginName, String loginPwd, String staffName, String gender, String onDutyDate) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;

    }

    public Staff(int id, String loginName, String loginPwd, String staffName, String gender, String onDutyDate) {
        this.id = id;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;

    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate='" + onDutyDate + '\'' +
                ", post=" + post +
                ", dept=" + dept +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
