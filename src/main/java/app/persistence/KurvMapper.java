package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Purpose:
 *
 * @author: Kevin Løvstad Schou
 */
public class KurvMapper {


    public static int getTotalPriceOfBasket(int userId,ConnectionPool connectionPool) {
        String sql = "SELECT SUM(total_price) " +
                "FROM users u " +
                "JOIN \"order\" o ON u.user_id = o.fk_user " +
                "JOIN orderline ol ON o.fk_orderline = ol.orderline_id " +
                "WHERE u.user_id = ? AND ol.status=false";
        int totalPrice = 0;

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                totalPrice = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Fejl ved beregning af totalpris", e);
        }

        return totalPrice;
    }



}
