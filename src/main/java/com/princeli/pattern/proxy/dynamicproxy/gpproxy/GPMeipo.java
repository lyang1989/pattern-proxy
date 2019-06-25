package com.princeli.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;


/**
 * @author : princeli
 * @version 1.0
 * @className GPMeipo
 * @date 2019-06-23 21:37
 * @description: TODO
 */
public class GPMeipo implements GPInvocationHandler{
    private Object target;

    public Object getInstance(Object person) throws Exception {
        this.target = person;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }


    private void before(){
        System.out.println("我是媒婆，我已确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，开始办事");
    }
}
