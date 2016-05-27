package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Category extends Model {
    @Id
    public Long id;
    @Required
    public String name;
    @CreatedTimestamp
    public Date createdDate;
    @UpdatedTimestamp
    public Date updatedDate;

    public static Finder<Long, Category> find = new Finder(Long.class, Category.class);

    public Category(String name) {
        this.name = name;
    }
}
