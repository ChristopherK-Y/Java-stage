import java.sql.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void 转账(int fromId, int toId, int money) throws SQLException, InterruptedException {
        try (Connection c = DatabaseUtil.getConnection()) {
            // 每个 Connection 对象都有自己的 autoCommit 属性
            c.setAutoCommit(false);  // 默认是 true    类似 start transaction

            try (PreparedStatement s1 = c.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement s2 = c.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                s1.setInt(1, money);
                s1.setInt(2, fromId);
                s1.executeUpdate();

                TimeUnit.SECONDS.sleep(10);
                int a = 1 / 0;

                s2.setInt(1, money);
                s2.setInt(2, toId);
                s2.executeUpdate();

                c.commit();
            } finally {
                c.rollback();
            }
        }
    }

    private static void 演示SQL注入(String name) throws SQLException {
        try (Connection c = DatabaseUtil.getConnection()) {
            String sql = String.format("SELECT * FROM accounts WHERE name = '%s'", name);
            System.out.println(sql);
            try (Statement s = c.createStatement()) {
                final ResultSet rs = s.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getString("id"));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getString("balance"));
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        演示SQL注入("' OR 1 = 1 OR name = '");
        //转账(1, 2, 10);
    }
}
