package com.princeli.pattern.proxy.dbroute;

/**
 * @author : princeli
 * @version 1.0
 * @className OrderDao
 * @date 2019-06-23 19:49
 * @description: TODO
 */
public class OrderDao {

    public int insert(Order order){
        System.out.println("OrderDao创建Order成功");
        return 1;
    }
}
