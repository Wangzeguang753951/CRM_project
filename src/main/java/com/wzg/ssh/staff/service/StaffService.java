package com.wzg.ssh.staff.service;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService {

    /**
     * 员工登录
     *
     * @param staff
     * @return
     */
    // 员工登录
    Staff login(Staff staff);


    /**
     * 查出所有的员工
     *
     * @param staff
     * @return
     */
    // 查出所有的员工

    List<Staff> getStaff(Staff staff);

    /**
     * 保存或者编辑
     *
     * @param staff
     */
    void saveOrUpdate(Staff staff);


    /**
     * 查询所有的部门
     *
     * @return
     */
    List<Department> getDept();

    /**
     * 根据员工ID查出所有的员工
     * @param
     * @return
     */
    List<Staff> getStaffsByStaffId(Staff staff);


    /**
     * 高级查询
     * @param deptId
     * @param postId
     * @param staffName
     * @return
     */
    // 高级查询
    List<Staff> getAllResult(int deptId, int postId, String staffName);

    /**
     * 修改密码
     * @param staff
     */
    void updatePwd(Staff staff);


}
