package com.princeli.pattern.proxy.test;

import com.princeli.pattern.proxy.dynamicproxy.cglibproxy.CGlibMeipo;
import com.princeli.pattern.proxy.dynamicproxy.cglibproxy.Customer;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author : princeli
 * @version 1.0
 * @className CglibTest
 * @date 2019-06-25 19:20
 * @description: TODO
 */
public class CglibTest {
    public static void main(String[] args) {
        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/liyang/Desktop/cglib_proxy_classes");

            Customer obj = (Customer) new CGlibMeipo().getInstance(Customer.class);
            System.out.println(obj);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
