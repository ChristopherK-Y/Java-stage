package service;

import model.Figure;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryService {
    public Figure query(int id) throws SQLException {
        try (Connection connection = DBUtil.connection()) {
            String sql = "SELECT imgHref,mainDescription,secondaryDescription FROM pictures WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                try (ResultSet set = preparedStatement.executeQuery()) {
                    set.next();
                    Figure figure = new Figure();
                    figure.imgHref = set.getString("imgHref");
                    figure.mainDescription = set.getString("mainDescription");
                    figure.secondaryDescription = set.getString("secondaryDescription");
                    return figure;
                }
            }
        }
    }
}
