package controllers;

import play.*;
import play.mvc.*;

import play.libs.Json;
import org.codehaus.jackson.node.ObjectNode;

import java.util.List;
import java.util.ArrayList;

import views.html.*;

public class Application extends Controller {
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result sayHello() {
        //String json = "[{\"name\":\"楽しくない仕事\",\"id\":\"4bbca9d7-4516-6aca-5b08-4ff55ad40cf9\"},{\"name\":\"いらいらする仕事\",\"id\":\"8d05924f-00f7-fbd1-29fb-a39f2ca6eba6\"},{\"name\":\"つまんない仕事\",\"id\":\"d65df2af-0ab9-a924-d5c2-ad4eae886c39\"}]";
        ObjectNode category  = Json.newObject();
        category.put("name", "楽しくない仕事");
        category.put("id", "4bbca9d7-4516-6aca-5b08-4ff55ad40cf9");

        List<ObjectNode> categories = new ArrayList<ObjectNode>();
        categories.add(category);
        categories.add(category);

        ObjectNode result = Json.newObject();
        result.put("categories", categories.toString());
        System.out.println(result);
        return ok(result);
    }
}
