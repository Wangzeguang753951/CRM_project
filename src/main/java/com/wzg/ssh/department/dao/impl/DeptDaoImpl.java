package com.wzg.ssh.department.dao.impl;

import com.wzg.ssh.department.dao.DeptDao;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {
    @Override
    public void saveOrUpdateDept(Department department) {

        if (department != null && department.getDeptId() == 0) {
            getHibernateTemplate().save(department);
        } else {

            getHibernateTemplate().saveOrUpdate(department);
        }


    }

    // 点击部门管理查出所有部门
    @Override
    public List<Department> getDept() {
        return getHibernateTemplate().loadAll(Department.class);
    }

    // 点击编辑后根据ID查出部门名字
    @Override
    public List<Department> getDeptByDeptId(int deptId) {
        String sql = "from Department crm_dept where deptId=?";
        return (List<Department>) getHibernateTemplate().find(sql, deptId);
    }


    // 根据部门ID查询所有职位
    @Override
    public List<Post> getPostByDeptId(Department dept) {

        String sql = "from Post crm_post where dept.deptId=?";

        return (List<Post>) getHibernateTemplate().find(sql, dept.getDeptId());

    }


}
