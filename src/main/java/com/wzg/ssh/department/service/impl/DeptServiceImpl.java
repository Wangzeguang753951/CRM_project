package com.wzg.ssh.department.service.impl;

import com.wzg.ssh.department.dao.DeptDao;
import com.wzg.ssh.department.service.DeptService;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao;

    @Override
    public void saveOrUpdateDept(Department department) {
         deptDao.saveOrUpdateDept(department);

    }


    @Override
    public List<Department> getDept() {
        return deptDao.getDept();
    }

    @Override
    public List<Department> getDeptByDeptId(int deptId) {
        return deptDao.getDeptByDeptId(deptId);
    }


    @Override
    public List<Post> getPostByDeptId(Department dept) {
        return deptDao.getPostByDeptId(dept);
    }






    public DeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
