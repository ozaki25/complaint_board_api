package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import java.util.Date;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

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

    public static Map<String, String> options() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for(Category category: find.all()) {
            options.put(category.id.toString(), category.name);
        }
        return options;
    }
}
