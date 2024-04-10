package app.persistence;

import app.entities.ConnectionPool;
import app.entities.Top;

import java.sql.*;
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




    public static int getTopPriceFromDatabase(int topId,ConnectionPool connectionPool) {

            String sql = "SELECT top_price FROM top WHERE top_id = ?";

            try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);

                ){
                ps.setInt(1,topId);
                try (ResultSet resultSet = ps.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("top_price");
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        return 0; // Returnerer 0 hvis top_price ikke kunne hentes
    }



    public static int getTopIdFromName(String topName, ConnectionPool connectionPool) {
        String sql = "SELECT top_id FROM top WHERE top = ?";
        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, topName);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("top_id");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return 0;  // Returnerer 0 hvis top_id ikke kunne hentes
    }
}
