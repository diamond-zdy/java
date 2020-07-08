package servlet;

import commen.OrderStatus;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class buyGoodsServletTest {

    @Test
    public void updateAfterPay() {
        buyGoodsServlet buy = new buyGoodsServlet();
        Goods goods = new Goods();
        goods.setStock(2);
        goods.setId(1);
        boolean flg = buy.updateAfterPay(goods,1);
        System.out.println(flg);
        System.out.println(goods);
    }

    @Test
    public void commitOrder() {
        buyGoodsServlet buy = new buyGoodsServlet();
        Order order = new Order();
        order.setId("123456789");
        order.setAccount_id(1);
        order.setActual_amount(45);
        order.setTotal_money(1500);
        order.setOrder_status(OrderStatus.OK);
        order.setAccount_name("zdy");
        order.setOrderItemList(order.orderItemList);
        //List<OrderItem> list = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsId(1);
        orderItem.setGoodsName("草莓");
        orderItem.setGoodsIntroduce("甜甜的");
        orderItem.setGoodsNum(1);
        orderItem.setGoodsUnit("盒");
        orderItem.setGoodsPrice(1500);
        orderItem.setGoodsDiscount(3);
        //order.getOrderItemList();
        boolean flg = buy.commitOrder(order);
        System.out.println(flg);

    }
}