package com.princeli.pattern.proxy.test;

import com.princeli.pattern.proxy.Person;
import com.princeli.pattern.proxy.dynamicproxy.gpproxy.GPMeipo;
import com.princeli.pattern.proxy.dynamicproxy.jdkproxy.Girl;


/**
 * @author : princeli
 * @version 1.0
 * @className JDKProxyTest
 * @date 2019-06-23 20:24
 * @description: TODO
 */
public class GPProxyTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new GPMeipo().getInstance(new Girl());
            obj.findLove();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
