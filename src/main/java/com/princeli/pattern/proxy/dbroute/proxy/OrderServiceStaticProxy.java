package com.princeli.pattern.proxy.dbroute.proxy;

import com.princeli.pattern.proxy.dbroute.IOrderService;
import com.princeli.pattern.proxy.dbroute.Order;
import com.princeli.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : princeli
 * @version 1.0
 * @className OrderServiceStaticProxy
 * @date 2019-06-23 20:00
 * @description: TODO
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();

        return 0;
    }
}
