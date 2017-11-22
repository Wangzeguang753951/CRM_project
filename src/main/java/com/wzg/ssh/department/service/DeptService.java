package com.wzg.ssh.department.service;

import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface DeptService {

    /**
     * 保存部门
     * @param department
     * @return
     */
    void saveOrUpdateDept(Department department);

    /**
     * 查询部门
     * @return
     */
    List<Department> getDept();



    /**
     * 根据部门ID查询所有职位
     * @param dept
     * @return
     */
    List<Post> getPostByDeptId(Department dept);



//    List<Department> getListByPage(int offset,int length);







}
