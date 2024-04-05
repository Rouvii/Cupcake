package app.persistence;

import app.entities.ConnectionPool;
import app.entities.Top;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Rouvillain
 */

public class TopMapper {



    public static List<Top> getAllTops (ConnectionPool connectionPool) {

        List<Top> topList = new ArrayList<>();
        String sql = "select * from top ";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)

        )
        {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("top");
                int price = rs.getInt("top_price");

                topList.add(new Top(name, price));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return topList;


    }
}
