import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Test {
    private static final DataSource dataSource;
    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("java20_0212");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
        dataSource = mysqlDataSource;
    }

    public static void main(String[] args) throws SQLException {
        createTable();
        insert();
        select();
    }

    private static void select() throws SQLException {
        String sql = "SELECT id,username FROM users";
        try(Connection c = dataSource.getConnection()){
            try(PreparedStatement statement = c.prepareStatement(sql)){
                try (ResultSet rs = statement.executeQuery()){
                    System.out.println("查询成功");
                    while (rs.next()){
                        int id = rs.getInt("id");
                        String username = rs.getString("username");
                        System.out.println(id + " ," + username);
                    }
                }
            }
        }
    }

    private static void insert() throws SQLException {
        String[] names = {"张丹莹","王哲林","杨雅文"};
        String sql = "INSERT INTO users (username) VALUES (?)";
        try(Connection c = dataSource.getConnection()){
            try(PreparedStatement statement = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                for(String name : names){
                    statement.setString(1,name);
                    statement.executeUpdate();
                    try(ResultSet resultSet = statement.getGeneratedKeys()){
                        resultSet.next();
                        int id = resultSet.getInt(1);
                        System.out.println("插入成功" + id + " ," + name);
                    }
                }
            }
        }
    }

    private static void createTable() throws SQLException {
        String sql = "CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(255))";
        try(Connection c = dataSource.getConnection()){
            try(PreparedStatement statement = c.prepareStatement(sql)){
                statement.executeUpdate();
            }
        }
    }
}
