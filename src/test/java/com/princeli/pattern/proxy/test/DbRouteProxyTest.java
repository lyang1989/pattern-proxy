package com.princeli.pattern.proxy.test;

import com.princeli.pattern.proxy.dbroute.IOrderService;
import com.princeli.pattern.proxy.dbroute.Order;
import com.princeli.pattern.proxy.dbroute.OrderService;
import com.princeli.pattern.proxy.dbroute.proxy.OrderServiceDynamicProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : princeli
 * @version 1.0
 * @className DbRouteProxyTest
 * @date 2019-06-23 20:07
 * @description: TODO
 */
public class DbRouteProxyTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            order.setCreateTime(new Date().getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            Date date = sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());
            //IOrderService orderService = new OrderServiceStaticProxy(new OrderService());

            IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);



        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
