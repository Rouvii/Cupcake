package app.persistence;

import app.entities.ConnectionPool;
import app.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Rouvi
 */


public class OrderlineMapper {




    public static void deleteOrderline(int orderId, ConnectionPool connectionPool) throws DatabaseException
    {
        String sql = "delete from orderline where fk_order_id = ?";

        try (Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new DatabaseException("Fejl i slet af en orderline");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Fejl ved sletning af orderline", e.getMessage());
        }
    }

}
