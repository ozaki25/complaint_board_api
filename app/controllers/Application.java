package controllers;

import play.*;
import play.mvc.*;

public class Application extends Controller {
    public static Result options(String path) {
        setHeader();
        return ok();
    }

    protected static void setHeader() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PUT, PATCH");
        response().setHeader("Access-Control-Allow-Headers", "Content-Type");
        response().setHeader("Access-Control-Allow-Credentials", "true");
    }
}
