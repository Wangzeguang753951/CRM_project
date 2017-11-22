package com.wzg.ssh.staff.service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.dao.StaffDao;
import com.wzg.ssh.staff.domain.Staff;
import com.wzg.ssh.staff.service.StaffService;
import com.wzg.ssh.utils.MD5Util;

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

    // 查出所有员工
    @Override
    public List<Staff> getStaff(Staff staff) {
        return staffDao.getStaff(staff);
    }

    // 保存所有的员工
    @Override
    public void saveOrUpdate(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }


    // 查出所有部门为二级联动所用
    @Override
    public List<Department> getDept() {
        return staffDao.getDept();
    }

    // 根据员工ID查询所有的员工
    @Override
    public List<Staff> getStaffsByStaffId(Staff staff) {
        return staffDao.getStaffsByStaffId(staff);
    }


    @Override
    public List<Staff> getAllResult(int deptId, int postId, String staffName) {

        //1全空
        if (deptId < 0 && postId < 0 && staffName.equals("")) {
            return staffDao.findAllStaffs(deptId, postId, staffName);
        }

        //2部门不空
        if (deptId > 0 && postId < 0 && staffName.equals("")) {
            return staffDao.findStaffsByDeptId(deptId, postId, staffName);
        }

        //3前两个不为空 后一个空
        if (deptId > 0 && postId > 0 && staffName.equals("")) {
            return staffDao.findStaffsByDeptIdAndPostId(deptId, postId, staffName);
        }

        //4 部门ID不为空 职位不为空 名字不为空
        if (deptId > 0 && postId > 0 && !staffName.equals("")) {
            return staffDao.findStaffsByDeptIdAndPostIdAndStaffName(deptId, postId, staffName);
        }


        //5 部门不为空 职位为空 名字不为空

        if (deptId > 0 && postId < 0 && !staffName.equals("")) {
            return staffDao.findStaffsByDeptIdAndStaffName(deptId, postId, staffName);
        }


        //6 部门为空 职位为空 名字不为空
            return staffDao.findStaffsByStaffName(deptId, postId, staffName);


    }

    // 修改密码
    @Override
    public void updatePwd(Staff staff) {
        staffDao.updatePwd(staff);
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
