 package app.controllers;
import app.entities.*;
import app.exceptions.DatabaseException;
import app.persistence.*;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;


public class OrderController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool)
    {

        app.get("menupage", ctx -> menupage(ctx, connectionPool));
    }

    private static void menupage(Context ctx, ConnectionPool connectionPool)
    {
        User user = ctx.sessionAttribute("currentUser");
        try{

            allTops(ctx,connectionPool);
            allBottoms(ctx,connectionPool);
            ctx.render("/menupage.html");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteOrderlines(Orderline orderline, Context ctx) {

        User user = ctx.sessionAttribute("currentUser");
        Cart cart = ctx.sessionAttribute("cart");
        //tager den aktive user og hans cart og sætter dem til variabler

        if (cart != null) {
            List<Orderline> newOrderline =cart.getCartItems();
            //hvis cart IKKE er tom, henter den brugerens varer

            newOrderline.remove(orderline);
            //sletter en orderline

            ctx.sessionAttribute("cart", cart);
            //updaterer cart
        }
    }
    //henter tops og sætter det i en arrayliste, listen bliver sat i ctx objektet.
    public static void allTops(Context ctx, ConnectionPool connectionPool) {
        try {
        List<Top> topList = new ArrayList<>(TopMapper.getAllTops(connectionPool));
        ctx.attribute("topList", topList);
        System.out.println(topList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // samme som før 🤣🔥🔥🔥💯💯 + exception handling
    public static void allBottoms(Context ctx, ConnectionPool connectionPool) {
        try {
            List<Bottom> bottomsList =  new ArrayList<>(BottomMapper.getAllBottoms(connectionPool));
            ctx.attribute("bottomsList", bottomsList);
            System.out.println(bottomsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Kigger på brugerens kart, hvis ikke null = henter items, og render ny side
    public static void createOrders(Context ctx, ConnectionPool connectionPool) {
        Cart cart = ctx.sessionAttribute("cart");
        if (cart != null) {
            ctx.attribute("orderlineArrayList", cart.getCartItems());
            ctx.render("payment.html");
        }
    }
}