package com.princeli.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @author : princeli
 * @version 1.0
 * @className GPInvocationHandler
 * @date 2019-06-23 21:26
 * @description: TODO
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
