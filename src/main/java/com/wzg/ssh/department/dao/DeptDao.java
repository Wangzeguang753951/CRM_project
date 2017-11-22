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
     * 查询部门的方法 点击部门管理
     * @return 部门的集合
     */

    List<Department> getDept();



    /**
     * 根据部门ID查询所有职位 点击部门编辑的时候执行
     *
     * @param dept
     * @return 职位的集合
     */
    List<Post> getPostByDeptId(Department dept);


    /**
     * 分页查询
     * @param offset
     * @param length
     * @return
     */


//    List<Department> getListByPage(int offset,int length);









}
