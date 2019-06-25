package com.princeli.pattern.proxy.test;

import com.princeli.pattern.proxy.staticproxy.Father;
import com.princeli.pattern.proxy.staticproxy.Son;

/**
 * @author : princeli
 * @version 1.0
 * @className FatherProxyTest
 * @date 2019-06-23 19:41
 * @description: TODO
 */
public class FatherProxyTest {

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();

    }

}
