package dao;

import model.Book;
import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> selectLikeNameOrderByPublishedAtDesc(String keyword) throws SQLException {
        String sql = "SELECT bid, isbn, name, total, stock, published_at FROM books WHERE name LIKE '%"
                + keyword + "%' ORDER BY published_at DESC";

        List<Book> bookList = new ArrayList<>();
        try (Connection c = DBUtil.connection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                try (ResultSet rs = s.executeQuery()) {
                    while (rs.next()) {
                        Book book = new Book();
                        book.bid = rs.getInt("bid");
                        book.isbn = rs.getInt("isbn");
                        book.name = rs.getString("name");
                        book.total = rs.getInt("total");
                        book.stock = rs.getInt("stock");
                        book.publishedAt = rs.getString("published_at");

                        bookList.add(book);
                    }
                }
            }
        }

        return bookList;
    }
}
