package app.controllers;
import app.entities.Order;
import app.entities.User;
import app.exceptions.DatabaseException;
import app.entities.ConnectionPool;
import app.persistence.OrderMapper;
import app.persistence.OrderlineMapper;
import app.persistence.UserMapper;
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
        app.post("deleteorder",ctx -> deleteOrder(ctx,connectionPool));
    }

    private static void adminpage(Context ctx, ConnectionPool connectionPool)
    {
        User user = ctx.sessionAttribute("currentUser");
        try{

            List<Order> orderList = OrderMapper.getAllOrders(connectionPool);
            List<User> userList = UserMapper.getAllUsers(connectionPool);
            System.out.println(orderList);
            ctx.attribute("userList",userList);
            ctx.attribute("orderList",orderList);
            ctx.render("/adminpage.html");

        } catch (Exception e) {

            System.out.println("fejl");
        }


    }

    private static void deleteOrder(Context ctx,ConnectionPool connectionPool){

        User user = ctx.sessionAttribute("currentUser");

        try {
            int orderId = Integer.parseInt(ctx.formParam("orderId"));
            OrderlineMapper.deleteOrderline(orderId, connectionPool);
            OrderMapper.deleteOrder(orderId, connectionPool);

            List<Order> orderList = OrderMapper.getAllOrders(connectionPool);

            ctx.attribute("orderList", orderList);
            ctx.render("adminpage.html");
        } catch (NumberFormatException | DatabaseException e) {
            ctx.attribute("message", e.getMessage());
            ctx.render("adminpage.html");
        }


    }


}
