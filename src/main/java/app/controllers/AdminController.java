package app.controllers;
import app.entities.Order;
import app.entities.User;
import app.exceptions.DatabaseException;
import app.entities.ConnectionPool;
import app.persistence.OrderMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;
import java.util.Map;

/**
 * @author Daniel Rouvillain
 */

public class AdminController {
    public static void addRoutes(Javalin app, ConnectionPool connectionPool)
    {

        app.get("admin", ctx -> adminpage(ctx, connectionPool));
    }

    private static void adminpage(Context ctx, ConnectionPool connectionPool)
    {
        User user = ctx.sessionAttribute("currentUser");
        try{

            List<Order> orderList = OrderMapper.getAllOrders(connectionPool);
            System.out.println(orderList);
            ctx.attribute("orderlist",orderList);
            ctx.render("/adminpage.html");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
