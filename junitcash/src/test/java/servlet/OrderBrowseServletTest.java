package servlet;

import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Order;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.*;

public class OrderBrowseServletTest {

    @Test
    public void queryOrderByAccount() {
        OrderBrowseServlet orderBrowseServlet = new OrderBrowseServlet();
        List<Order> list = orderBrowseServlet.queryOrderByAccount(1);
        System.out.println("size = " + list.size());
        System.out.println();
        for (Order order : list){
            System.out.println(order.getId());
        }
    }

}