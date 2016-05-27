package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import static play.data.Form.*;

import models.Category;
import views.html.categories.*;

public class CategoriesController extends Controller {
    final static Form<Category> categoryForm = form(Category.class);

    public static Result index() {
        return ok(index.render(Category.find.all()));
    }

    public static Result newCategory() {
        return ok(newCategory.render(categoryForm));
    }

    public static Result edit(Long id) {
        Category category = Category.find.byId(id);
        return ok(edit.render(categoryForm.fill(category)));
    }

    public static Result create() {
        Category category = categoryForm.bindFromRequest().get();
        category.save();
        return redirect(routes.CategoriesController.index());
    }

    public static Result update(Long id) {
        Form<Category> form = categoryForm.bindFromRequest();
        Category category = Category.find.byId(id);
        category = form.get();
        category.update(id);
        return redirect(routes.CategoriesController.index());
    }

    public static Result delete(Long id) {
        Category category = Category.find.byId(id);
        category.delete();
        return redirect(routes.CategoriesController.index());
    }

    public static Result setUp() {
        Category category1 = new Category("楽しくない仕事");
        category1.save();
        Category category2 = new Category("いらいらする仕事");
        category2.save();
        Category category3 = new Category("つまんない仕事");
        category3.save();

        return redirect(routes.CategoriesController.index());
    }
}
