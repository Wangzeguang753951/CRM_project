package com.wzg.ssh.staff.dao.impl;

import com.wzg.ssh.staff.dao.StaffDao;
import com.wzg.ssh.staff.domain.Department;
import com.wzg.ssh.staff.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    // 查处数据库中的员工信息集合
    @Override
    public Staff login(Staff staff) {

        List<Staff> staffs = getHibernateTemplate().findByExample(staff);

        if (staffs!=null&&staffs.size() > 0){
            return staffs.get(0);
        }
        return null;

    }

    // 插入部门的方法
    @Override
    public Department saveDept(Department dept) {
        getHibernateTemplate().save(dept);
        return dept;

    }

    // 保存员工的方法
    @Override
    public Staff saveStaff(Staff staff) {
        getHibernateTemplate().save(staff);
        return staff;
    }

    // 查出所有的部门
    @Override
    public List<Department> getDepartment() {
        return null;
    }

    // 根据部门id查询所有的职位

    @Override
    public List<Post> getPostByDeptId(int deptId) {
        return null;
    }

    // 根据部门和职位ID查询所有员工

    @Override
    public List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId) {
        return null;
    }

    // 根据部门ID查询所有员工

    @Override
    public List<Staff> getStaffByDeptId(int deptId) {
        return null;
    }

    // 查询所有的员工
    @Override
    public List<Staff> getStaffs() {
        return null;
    }



}
