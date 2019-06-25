package com.princeli.pattern.proxy.dynamicproxy.jdkproxy;

import com.princeli.pattern.proxy.Person;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : princeli
 * @version 1.0
 * @className JDKMeiPo
 * @date 2019-06-23 20:19
 * @description: TODO
 */
public class JDKMeiPo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person person) throws Exception {
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

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
