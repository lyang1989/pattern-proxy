package com.princeli.pattern.proxy.staticproxy;

import com.princeli.pattern.proxy.Person;

/**
 * @author : princeli
 * @version 1.0
 * @className Father
 * @date 2019-06-23 19:35
 * @description: TODO
 */
public class Father implements Person {
    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    @Override
    public void findLove(){
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确立关系");
    }
}
