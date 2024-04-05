package app;

import app.config.ThymeleafConfig;
import app.controllers.AdminController;
import app.controllers.UserController;
import app.entities.Bottom;
import app.entities.ConnectionPool;
import app.entities.Top;
import app.persistence.BottomMapper;
import app.persistence.TopMapper;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.util.List;

public class Main {
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5433/%s?currentSchema=public";
    private static final String DB = "cupcake";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(USER, PASSWORD, URL, DB);

    public static void main(String[] args) {
        // Initializing Javalin and Jetty webserver

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinThymeleaf(ThymeleafConfig.templateEngine()));
        }).start(7070);

        // Routing


        app.get("/", ctx -> ctx.render("index.html"));
        AdminController.addRoutes(app,connectionPool);
        UserController.addRoutes(app,connectionPool);

    }








}

