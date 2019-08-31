package com.princeli.pattern.proxy.dbroute.proxy;

import com.princeli.pattern.proxy.dbroute.db.DynamicDataSourceEntity;
import com.princeli.pattern.proxy.dynamicproxy.gpproxy.GPClassLoader;
import com.princeli.pattern.proxy.dynamicproxy.gpproxy.GPInvocationHandler;
import com.princeli.pattern.proxy.dynamicproxy.gpproxy.GPProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : princeli
 * @version 1.0
 * @className OrderServiceStaticProxy
 * @date 2019-06-23 20:00
 * @description: TODO
 */
public class OrderServiceDynamicProxy implements GPInvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    Object proxyObj;

    public Object getInstance(Object proxyObj) {
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);

        Object object = method.invoke(proxyObj,args);

        after();
        return object;
    }



    private void after() {
        System.out.println("Proxy after method");
        DynamicDataSourceEntity.restore();
    }

    private void before(Object target){
        try {
            System.out.println("Proxy before method");
            Long time = (Long)target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
