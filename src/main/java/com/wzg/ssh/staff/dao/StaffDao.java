package com.wzg.ssh.staff.dao;

import com.wzg.ssh.staff.domain.Department;
import com.wzg.ssh.staff.domain.Post;
import com.wzg.ssh.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
    /**
     * 员工登录
     * @param staff
     * @return
     */
    // 员工登录
    Staff login(Staff staff);


    /**
     * 插入部门的方法
     *
     * @return
     */
    // 插入部门
    Department saveDept(Department dept);

    /**
     * 插入员工
     * @param staff
     * @return
     */
    // 插入员工
    Staff saveStaff(Staff staff);



    /**
     * 查询所有部门
     * @return
     */
    // 查询所有部门
    List<Department> getDepartment();


    /**
     * 根据部门ID查询所有的职位
     * @param deptId 部门的ID
     * @return 职位的集合
     */
    List<Post> getPostByDeptId(int deptId);


    /**
     * 根据部门和职位的ID查询出所有对应的员工
     * @param deptId 部门ID
     * @param postId 职位ID
     * @return 员工集合
     */
    List<Staff> getStaffByDeptIdAndPostId(int deptId,int postId);




    /**
     * 查询某个部门的所有员工
     * @param deptId 部门ID
     * @return 员工集合
     */
    List<Staff> getStaffByDeptId(int deptId);





    /**
     * 查询所有员工
     * @return
     */
    List<Staff> getStaffs();








}
