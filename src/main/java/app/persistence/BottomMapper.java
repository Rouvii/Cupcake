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



    public static int getBottomPriceFromDatabase(int bottomId,ConnectionPool connectionPool) {

        String sql = "SELECT bottom_price FROM bottom WHERE bottom_id = ?";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);

        ){
            ps.setInt(1,bottomId);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("bottom_price");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        return 0; //Returnere 0 hvis bottom_price ikke kunne hentes
    }



    public static int getBottomIdFromName(String bottomName, ConnectionPool connectionPool) {
        String sql = "SELECT bottom_id FROM bottom WHERE bottom = ?";
        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, bottomName);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("bottom_id");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return 0; // Returnerer 0 hvis bottom_id ikke kunne hentes
    }
}
