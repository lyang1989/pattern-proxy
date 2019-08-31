package com.princeli.pattern.proxy.dynamicproxy.jdkproxy;

import com.princeli.pattern.proxy.Person;

/**
 * @author : princeli
 * @version 1.0
 * @className Girl
 * @date 2019-06-23 20:18
 * @description: TODO
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高189");
    }

    @Override
    public void findJob(){

    }
}
