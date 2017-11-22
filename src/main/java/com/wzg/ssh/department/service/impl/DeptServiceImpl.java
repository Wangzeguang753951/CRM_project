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

    // deptDao对象
    private DeptDao deptDao;

    // 保存或者编辑部门
    @Override
    public void saveOrUpdateDept(Department department) {

        deptDao.saveOrUpdateDept(department);

    }

    // 查询所有部门
    @Override
    public List<Department> getDept() {
        return deptDao.getDept();
    }

    //根据部门ID查询所有职位
    @Override
    public List<Post> getPostByDeptId(Department dept) {
        return deptDao.getPostByDeptId(dept);
    }


//    //分页查询
//    @Override
//    public List<Department> getListByPage(int offset, int length) {
//        return deptDao.getListByPage(offset,length);
//    }


    //设置set方法 Spring配置文件用
    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
