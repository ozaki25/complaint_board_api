package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import static play.data.Form.*;

import models.Comment;
import views.html.comments.*;

public class CommentsController extends Controller {
    final static Form<Comment> commentForm = form(Comment.class);

    public static Result index() {
        return ok(index.render(Comment.find.all()));
    }

    public static Result newComment() {
        return ok(newComment.render(commentForm));
    }

    public static Result edit(Long id) {
        Comment comment = Comment.find.byId(id);
        return ok(edit.render(commentForm.fill(comment)));
    }

    public static Result create() {
        Comment comment = commentForm.bindFromRequest().get();
        comment.save();
        return redirect(routes.CommentsController.index());
    }

    public static Result update(Long id) {
        Form<Comment> form = commentForm.bindFromRequest();
        Comment comment = Comment.find.byId(id);
        comment = form.get();
        comment.update(id);
        return redirect(routes.CommentsController.index());
    }

    public static Result delete(Long id) {
        Comment comment = Comment.find.byId(id);
        comment.delete();
        return redirect(routes.CommentsController.index());
    }
}
