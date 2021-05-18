package service;

import model.Figure;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FigureService {
    public List<Figure> getFigureList() throws SQLException {
        List<Figure> list = new ArrayList<>();
        try (Connection connection = DBUtil.connection()) {
            String sql = "SELECT id,imgHref,mainDescription,secondaryDescription FROM pictures ORDER BY imgPriority";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet set = preparedStatement.executeQuery()) {
                    while (set.next()) {
                        Figure figure = new Figure();
                        figure.id = set.getInt("id");
                        figure.imgHref = set.getString("imgHref");
                        figure.mainDescription = set.getString("mainDescription");
                        figure.secondaryDescription = set.getString("secondaryDescription");
                        list.add(figure);
                    }
                    return list;
                }
            }
        }
    }
}
