package com.princeli.pattern.proxy.staticproxy;

import com.princeli.pattern.proxy.Person;

/**
 * @author : princeli
 * @version 1.0
 * @className Son
 * @date 2019-06-23 19:35
 * @description: TODO
 */
public class Son implements Person {

    @Override
    public void findLove(){
        System.out.println("儿子要求");
    }
}
