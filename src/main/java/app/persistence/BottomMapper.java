package app.persistence;

import app.entities.Bottom;
import app.entities.ConnectionPool;
import app.entities.Top;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Rouvillain
 */

public class BottomMapper {

    public static List<Bottom> getAllBottoms (ConnectionPool connectionPool) {

        List<Bottom> bottomList = new ArrayList<>();
        String sql = "select bottom,bottom_price from bottom ";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)

        )
        {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("bottom");
                int price = rs.getInt("bottom_price");
                bottomList.add(new Bottom(name, price));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return bottomList;


    }
}
