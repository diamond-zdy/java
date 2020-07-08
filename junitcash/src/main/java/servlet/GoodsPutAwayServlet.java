package servlet;

import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.HttpCookie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/inbound")
public class GoodsPutAwayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String stock = req.getParameter("stock");
        String introduce = req.getParameter("introduce");
        String unit = req.getParameter("unit");
        String price = req.getParameter("price");
        String discount = req.getParameter("discount");

        double doublePrice = Double.valueOf(price);
        int realPrice = new Double(100*doublePrice).intValue();

        Connection connection = null;
        PreparedStatement ps = null;

        Writer writer = resp.getWriter();
        try{
            String sql = "insert into goods(name,introduce,stock,unit,price,discount) values(?,?,?,?,?,?)";
            connection = DBUtil.getConnection(true);
            ps = connection.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,introduce);
            ps.setInt(3, Integer.parseInt(stock));
            ps.setString(4,unit);
            ps.setInt(5,realPrice);
            ps.setInt(6, Integer.parseInt(discount));

            int ret = ps.executeUpdate();
            if (ret == 0 ){
                System.out.println("商品入库失败！");
                writer.write("<h2> 商品入库失败</h2>");
            }else {
                System.out.println("商品入库成功！");
                writer.write("<h2> 商品入库成功</h2>");
                resp.sendRedirect("index.html");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,null);
        }

    }
}
