package com.wzg.ssh.base;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by dllo on 17/11/9.
 */
/*
泛型 : 也可以称之为类的参数 参数类型是某个类 而不是对象
        E:Element/Entity
        T:代表type
 */

public class BaseAction<T,S> extends ActionSupport implements ModelDriven<T> {

    private T model;

    protected S service;

    public BaseAction() {

        // 获取当前类的class
        Class<? extends BaseAction> clazz = getClass();
        // 获取父类的泛型参数
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
        // 获取所有的泛型集合(因为可能有多个泛型)
        Type[] typeArguments = type.getActualTypeArguments();
        // 因为当前类只有一个泛型参数
        // 所以取第0个
        Class modelClass = (Class) typeArguments[0];

        // 根据反射创建出泛型的对象
        try {
            model = (T) modelClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public T getModel() {
        return model;
    }



    // 向session中存放数据
    public void sessionPut(String key, Object value) {

        ActionContext.getContext().getSession().put(key, value);

    }
    public void sessionRemove(String key){
        ActionContext.getContext().getSession().remove(key);
    }



    public void sessionGet(String key){
        ActionContext.getContext().getSession().get(key);
    }


    // application
    public void applicationPut(String key,Object value){
        ActionContext.getContext().getApplication().put(key,value);
    }
    // request

    // context


    // 使用request和respons对象的封装
    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getRespons(){
        return ServletActionContext.getResponse();
    }



    public void setService(S service) {
        this.service = service;
    }

}
