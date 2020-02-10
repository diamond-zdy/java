import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/2020_0210?useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "";
        Connection connection = (Connection) DriverManager.getConnection(url,user,password);

        {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users(id,name) VALUES (1,'张丹莹'),(2,'林林'),(3,'文文')";
            statement.executeUpdate(sql);
            statement.close();
        }

        {
            Statement statement = connection.createStatement();
            String sql = "SELECT id,name FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> nameList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                nameList.add(name);
                System.out.println(id + " ," + name);
            }
            resultSet.close();
            statement.close();
        }

        /*//INSERT
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO users (id,name) VALUES (1,'NAME'),(2,NAME)";
        statement.executeUpdate(sql);
        //UPDATE
        String sql = "UPDATA users SET name = '..' WHERE id = 1";
        statement.executeUpdate(sql);
        //DELETE
        String sql = "DELETE FROM users WHERE id = 1";
        statement.executeUpdate(sql);*/
    }
}
