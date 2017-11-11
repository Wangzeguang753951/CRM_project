package com.wzg.ssh.staff.service.impl;

import com.wzg.ssh.staff.dao.StaffDao;
import com.wzg.ssh.staff.domain.Department;
import com.wzg.ssh.staff.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import com.wzg.ssh.staff.service.StaffService;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffServiceImpl implements StaffService {


    private StaffDao staffDao;

    // 员工登录
    @Override
    public Staff login(Staff staff) {
        return staffDao.login(staff);
    }

    // 插入部门
    @Override
    public Department saveDept(Department dept) {
        return staffDao.saveDept(dept);
    }

    // 插入员工信息
    @Override
    public Staff saveStaff(Staff staff) {
        return staffDao.saveStaff(staff);
    }

    @Override
    public List<Department> getDepartment() {
        return null;
    }

    @Override
    public List<Post> getPostByDeptId(int deptId) {
        return null;
    }

    @Override
    public List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId) {
        return null;
    }

    @Override
    public List<Staff> getStaffByDeptId(int deptId) {
        return null;
    }

    @Override
    public List<Staff> getStaffs() {
        return null;
    }

    // 使用userDao 对象
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
