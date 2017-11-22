package com.wzg.ssh.department.dao.impl;

import com.wzg.ssh.department.dao.DeptDao;
import com.wzg.ssh.department.domain.Department;
import com.wzg.ssh.post.domain.Post;
import com.wzg.ssh.staff.domain.Staff;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {


    // 保存或者编辑部门
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


    // 根据部门ID查询所有职位
    @Override
    public List<Post> getPostByDeptId(Department dept) {

        String sql = "from Post crm_post where dept.deptId=?";

        return (List<Post>) getHibernateTemplate().find(sql, dept.getDeptId());

    }



//    @Override
//    public List<Department> getListByPage(int offset, int length) {
//
//        String sql = "from Department crm_dept";
//
//       List<Department>list = getHibernateTemplate().execute(new HibernateCallback<List<Department>>() {
//            @Override
//            public List<Department> doInHibernate(Session session) throws HibernateException {
//                Query query = session.createQuery(sql);
//                query.setFirstResult(offset);
//                query.setMaxResults(length);
//                List<Department> list1 = query.list();
//                return list1;
//            }
//        });
//        return list;
//    }

//    // 分页查询
//    @Override
//    public List<Department> queryByPage(int offset, int length) {
//        //第一个参数开始读取条数
//        final String sql = "from Department crm_dept";
//                getHibernateTemplate().execute(new HibernateCallback<String>() {
//                    @Override
//                    public String doInHibernate(Session session) throws HibernateException {
//                        Query query = session.createQuery(sql);
//
//                    }
//                })
//    }


}
