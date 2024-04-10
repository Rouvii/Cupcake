 package app.controllers;
import app.entities.*;
import app.persistence.*;
import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.ArrayList;
import java.util.List;

 public class OrderController {
private static Cart cart1 = new Cart();
     private static List<String> cart =new ArrayList<>();
    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {

        app.get("menupage", ctx -> menupage(ctx, connectionPool));
        app.post("/order",ctx->addToCart(ctx,connectionPool));
        app.get("/betaling", ctx -> ctx.render("/overview.html"));

    }


    private static void menupage(Context ctx, ConnectionPool connectionPool) {


        User user = ctx.sessionAttribute("currentUser");
        try{

            allTops(ctx,connectionPool);
            allBottoms(ctx,connectionPool);
            ctx.render("/menupage.html");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

     private static void addToCart(Context ctx,ConnectionPool connectionPool){
         String top = ctx.formParam("top");
         String bottom = ctx.formParam("bottom");
         int quantity = Integer.parseInt(ctx.formParam("quantity"));
        try {

            int topId = TopMapper.getTopIdFromName(top,connectionPool);
            int bottomId = BottomMapper.getBottomIdFromName(bottom,connectionPool);


            int topPrice = TopMapper.getTopPriceFromDatabase(topId, connectionPool);
            int bottomPrice = BottomMapper.getBottomPriceFromDatabase(bottomId, connectionPool);
            // Beregner den samlede pris for cupcaken baseret på de valgte top og bottom samt mængden
            int totalPriceOfCupcake = (topPrice + bottomPrice) * quantity;

            int totalPriceOfCart = Cart.calculateTotalPrice(cart1.getCartItems(), connectionPool);


            // Opretter en string af en cupcake med dens top,bund og antal
            String cupcake = "Top: " + top + ", Bottom: " + bottom + ", Quantity: " + quantity + ", Total price: " + totalPriceOfCupcake + " kr";
            cart1.addToCart(new Orderline(topId, bottomId, quantity));
            ctx.sessionAttribute("cartItems", cart1.getCartItems());
            // Tilføjer cupcaken til indkøbskurvens liste over cupcakes
            cart.add(cupcake);
            ctx.attribute("totalPrice", totalPriceOfCart);
            ctx.attribute("cart", cart);
            allTops(ctx, connectionPool);
            allBottoms(ctx, connectionPool);
            // Rendrer siden menupage med de opdaterede data
            ctx.render("menupage");
        }catch (NumberFormatException e){
            e.getMessage();
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
            ctx.render("/overview.html");
        }
    }
}