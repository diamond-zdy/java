package servlet;

import entity.Goods;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodUpdateServletTest {

    @Test
    public void getGoods() {
        GoodUpdateServlet goodUpdateServlet = new GoodUpdateServlet();
        //int goodsId = 1;
        System.out.println(goodUpdateServlet.getGoods(1));
    }
}