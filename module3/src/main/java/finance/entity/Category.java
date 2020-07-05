package finance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private Integer categoryId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Operation> operation;

    private boolean isProfit;

    public Category() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void addOperation(Operation operation) {
        this.operation.add(operation);
    }

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Operation> getOperation() {
        return operation;
    }

    public void setOperation(List<Operation> operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + categoryId +
                ", operation=" + operation +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}