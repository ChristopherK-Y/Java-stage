package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final DataSource dataSource;

    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("579333");
        mysqlDataSource.setDatabaseName("LMS");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
        mysqlDataSource.setServerTimezone("Asia/Shanghai");

        dataSource = mysqlDataSource;
    }

    public static Connection connection() throws SQLException {
        return dataSource.getConnection();
    }
}
