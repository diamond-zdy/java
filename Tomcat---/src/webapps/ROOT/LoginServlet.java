package webapps.ROOT;

import standard.HttpServlet;
import standard.HttpServletRequest;
import standard.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static com.sun.xml.internal.bind.api.impl.NameConverter.standard;

public class LoginServlet extends HttpServlet {
    private int i = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        i++;    // 线程不安全的

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // TODO: 验证用户名密码是否正确
        // TODO: 设置 Session 信息

        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("登录成功");
    }
}
