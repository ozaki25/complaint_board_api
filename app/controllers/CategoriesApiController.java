package controllers;

import play.*;
import play.mvc.*;
import play.libs.Json;

import org.codehaus.jackson.node.ObjectNode;
import java.util.List;
import java.util.ArrayList;

import models.Category;

public class CategoriesApiController extends Controller {
    public static Result index() {
        response().setHeader("Access-Control-Allow-Origin", "*");

        List<Category> categoryList = Category.find.all();
        System.out.println(Json.toJson(categoryList));

        return ok(Json.toJson(categoryList));
    }

    public static Result create() {
        return ok();
    }

    public static Result update(Long id) {
        return ok();
    }

    public static Result delete(Long id) {
        return ok();
    }
}
