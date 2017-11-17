package com.wzg.ssh.staff.dao;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import javafx.geometry.Pos;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
    /**
     * 员工登录
     *
     * @param staff
     * @return 返回用户名和密码
     */
    // 员工登录
    Staff login(Staff staff);


    /**
     * 查询所有的员工
     *
     * @param staff
     * @return 员工集合
     */
    List<Staff> getStaff(Staff staff);


    /**
     * 保存或者编辑
     *
     * @param staff
     */
    void saveOrUpdate(Staff staff);

    /**
     * 查出所有的部门
     *
     * @return
     */
    List<Department> getDept();


    //1全空
    List<Staff> findAllStaffs(int deptId, int postId, String staffName);

    //2 部门ID不为空其他为空

    List<Staff> findStaffsByDeptId(int deptId, int postId, String staffName);

    //3 部门ID不为空 职位ID不为空 名字为空

    List<Staff> findStaffsByDeptIdAndPostId(int deptId, int postId, String staffName);

    //4 部门ID不为空 职位不为空 名字不为空

    List<Staff> findStaffsByDeptIdAndPostIdAndStaffName(int deptId, int postId, String staffName);

    //5 部门不为空 职位为空 名字不为空

    List<Staff> findStaffsByDeptIdAndStaffName(int deptId, int postId, String staffName);

    //6 部门为空 职位为空 名字不为空

    List<Staff> findStaffsByStaffName(int deptId, int postId, String staffName);




}
