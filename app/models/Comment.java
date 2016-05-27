package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Comment extends Model {
    @Id
    public Long id;
    @Required
    public String content;
    @ManyToOne
    @Required
    public Category category;
    @CreatedTimestamp
    public Date createdDate;
    @UpdatedTimestamp
    public Date updatedDate;

    public static Finder<Long, Comment> find = new Finder(Long.class, Comment.class);

    public Comment(String content, Long categoryId) {
        Category category = Category.find.byId(categoryId);
        this.content = content;
        this.category = category;
    }
}
