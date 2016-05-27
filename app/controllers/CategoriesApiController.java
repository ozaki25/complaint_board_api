package controllers;

import play.*;
import play.mvc.*;
import play.libs.Json;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import java.util.List;
import java.util.ArrayList;

import models.Category;

public class CategoriesApiController extends Application {
    public static Result index() {
        setHeader();
        List<Category> categoryList = Category.find.all();
        System.out.println(Json.toJson(categoryList));
        return ok(Json.toJson(categoryList));
    }

    public static Result create() {
        setHeader();
        JsonNode json = request().body().asJson();
        System.out.println(json);
        String name = json.get("name").asText();
        Category category = new Category(name);
        category.save();
        return ok();
    }

    public static Result update(Long id) {
        setHeader();
        JsonNode json = request().body().asJson();
        System.out.println(json);
        String name = json.get("name").asText();
        Category category = Category.find.byId(id);
        category.name = name;
        category.update(id);
        return ok();
    }

    public static Result delete(Long id) {
        setHeader();
        Category category = Category.find.byId(id);
        category.delete();
        return ok();
    }
}
