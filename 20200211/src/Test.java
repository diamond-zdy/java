import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Test {
    private static int globalUserId = -1;
    private static String globalUsername = null;
    private static final String url = "jdbc:mysql://127.0.0.1:3306/java20_0211?useSSL=false&characterEncoding=utf8";
    private static final String mysqlUsername = "root";
    private static final String mysqlPassword = "";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Scanner scanner = new Scanner(System.in);

        while (true){
            menu();
            int select = scanner.nextInt();
            scanner.nextLine();

            switch (select){
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    publish();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }

    private static void publish() throws SQLException {
        if(globalUserId == -1){
            System.out.println("请先登录");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String content = scanner.nextLine();

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("java20_0211");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
        DataSource dataSource = mysqlDataSource;

        String sql = "INSERT INTO articles (author_id,title,content) VALUES (?,?,?)";
        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,globalUserId);
                statement.setString(2,title);
                statement.setString(3,content);
                statement.executeUpdate();
                System.out.println("发表成功");
            }
        }
    }

    //用户登录
    private static void login() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("java20_0211");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        DataSource dataSource = mysqlDataSource;
        try(Connection connection = dataSource.getConnection()){
            String sql = "SELECT id,username FROM users WHERE username = ? AND password = ?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,username);
                statement.setString(2,password);
                com.mysql.jdbc.PreparedStatement mysqlStatement = (com.mysql.jdbc.PreparedStatement) statement;
                System.out.println(mysqlStatement.asSql());
                try(ResultSet resultSet = statement.executeQuery()){
                    if(!resultSet.next()){
                        System.out.println("登录失败");
                    }else {
                        int id = resultSet.getInt("id");
                        String usernameInTable = resultSet.getString("username");
                        globalUserId = id;
                        globalUsername = usernameInTable;
                        System.out.println("登陆成功"+id + " ," + usernameInTable);
                    }
                }
            }
        }

    }

    private static void register() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        /*
        Connection connection = DriverManager.getConnection(url,mysqlUsername,mysqlPassword);
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO users(username,password) VALUES ('%s','%s')",username,password);
        System.out.println(sql);
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
        */
        try(Connection connection = DriverManager.getConnection(url,mysqlUsername,mysqlPassword)){
            try(Statement statement = connection.createStatement()){
                String sql = String.format("INSERT INTO users(username,password) VALUES ('%s','%s')",username,password);
                System.out.println(sql);
                statement.executeUpdate(sql);
            }
        }
        System.out.println("用户注册成功");
    }

    private static void menu() {
        System.out.println("==================");
        System.out.println("1.用户注册");
        System.out.println("2.用户登录");
        System.out.println("3.发表文章");
        System.out.println("4.文章列表页");
        System.out.println("5.文章详情页");
        System.out.println("==================");
    }
}
