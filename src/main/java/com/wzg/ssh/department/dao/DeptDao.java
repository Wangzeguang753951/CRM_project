package com.wzg.ssh.department.dao;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface DeptDao {
    /**
     * 保存部门 或者添加部门
     *
     * @param department
     * @return
     */
    void saveOrUpdateDept(Department department);

    /**
     * 查询部门的方法
     *
     * @return 部门的集合
     */
    // 点击部门管理走这个方法
    List<Department> getDept();

    // 点击编辑
    List<Department> getDeptByDeptId(int deptId);


    /**
     * 根据部门ID查询所有职位
     *
     * @param dept
     * @return
     */
    List<Post> getPostByDeptId(Department dept);









}
