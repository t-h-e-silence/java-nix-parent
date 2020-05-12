package finance.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private Integer category_id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Operation operation;

    public Category() {
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }


    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", operation=" + operation +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}