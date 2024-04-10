package app.persistence;

import app.entities.ConnectionPool;
import app.entities.Order;
import app.entities.Top;
import app.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Rouvillain
 */

public class OrderMapper {

    public static List<Order> getAllOrders (ConnectionPool connectionPool) {

        List<Order> orderList = new ArrayList<>();
        String sql = "select order_id,fk_user,final_price from \"order\"  order by fk_user";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)

        )
        {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int userId = rs.getInt("fk_user");
                int price = rs.getInt("final_price");
                System.out.println("Retrieved name: " + orderId + "userId "+ userId + ", price: " + price); // Add this line for debugging
                orderList.add(new Order(orderId,userId,price));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderList;


    }

    public static void deleteOrder(int orderId, ConnectionPool connectionPool) throws DatabaseException {

        String deleteOrderSql = "DELETE FROM \"order\" WHERE order_id = ?";

        try (
                Connection connection = connectionPool.getConnection();

                PreparedStatement deleteOrderStatement = connection.prepareStatement(deleteOrderSql)
        ) {
            deleteOrderStatement.setInt(1, orderId);
            int rowsAffected = deleteOrderStatement.executeUpdate();



            if (rowsAffected !=1) {
                throw new DatabaseException("Failed to delete order");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting order: " + e.getMessage());
        }
    }

}
