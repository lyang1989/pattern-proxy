package com.princeli.pattern.proxy.dbroute;

/**
 * @author : princeli
 * @version 1.0
 * @className OrderService
 * @date 2019-06-23 19:51
 * @description: TODO
 */
public class OrderService implements IOrderService{
    public OrderDao orderDao;


    public OrderService() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
