package controllers;

import play.*;
import play.mvc.*;
import play.libs.Json;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import java.util.List;
import java.util.ArrayList;

import models.Comment;
import models.Category;

public class CommentsApiController extends Application {
    public static Result index() {
        setHeader();
        List<Comment> commentList = Comment.find.all();
        System.out.println(Json.toJson(commentList));
        return ok(Json.toJson(commentList));
    }

    public static Result create() {
        setHeader();
        JsonNode json = request().body().asJson();
        System.out.println(json);
        String content = json.get("content").asText();
        Long categoryId = json.get("categoryId").asLong();
        Comment comment = new Comment(content, categoryId);
        comment.save();
        return ok(Json.toJson(comment));
    }

    public static Result update(Long id) {
        setHeader();
        JsonNode json = request().body().asJson();
        System.out.println(json);
        String content = json.get("content").asText();
        Long categoryId = json.get("categoryId").asLong();
        Comment comment = Comment.find.byId(id);
        Category category = Category.find.byId(categoryId);
        comment.content = content;
        comment.category = category;
        comment.update(id);
        return ok(Json.toJson(comment));
    }

    public static Result delete(Long id) {
        setHeader();
        Comment comment = Comment.find.byId(id);
        comment.delete();
        System.out.println(Json.toJson(comment));
        return ok(Json.toJson(comment));
    }
}
