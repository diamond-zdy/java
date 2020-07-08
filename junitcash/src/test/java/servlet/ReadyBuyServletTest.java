package servlet;

import entity.Goods;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadyBuyServletTest {

    @Test
    public void getGoods() {
        ReadyBuyServlet readyBuyServlet = new ReadyBuyServlet();
        System.out.println(readyBuyServlet.getGoods(1));
    }
}