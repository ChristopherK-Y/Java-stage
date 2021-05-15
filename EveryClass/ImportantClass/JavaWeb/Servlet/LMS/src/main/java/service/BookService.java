package service;

import dao.BookDao;
import model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private final BookDao bookDao = new BookDao();

    public List<Book> search(String keyword) throws SQLException {
        return bookDao.selectLikeNameOrderByPublishedAtDesc(keyword);
    }
}
