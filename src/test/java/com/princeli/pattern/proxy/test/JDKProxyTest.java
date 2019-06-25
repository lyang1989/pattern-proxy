package com.princeli.pattern.proxy.test;

import com.princeli.pattern.proxy.Person;
import com.princeli.pattern.proxy.dynamicproxy.jdkproxy.Girl;
import com.princeli.pattern.proxy.dynamicproxy.jdkproxy.JDKMeiPo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author : princeli
 * @version 1.0
 * @className JDKProxyTest
 * @date 2019-06-23 20:24
 * @description: TODO
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeiPo().getInstance(new Girl());
            obj.findLove();

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("/Users/liyang/Desktop/$Proxy0.class");
            os.write(bytes);
            os.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
