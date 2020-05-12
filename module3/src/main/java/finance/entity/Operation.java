package finance.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operation_id;
    private String name;
    private Double cost;

    @ManyToOne( cascade = CascadeType.ALL)
    private BankAccount account;

    @Embedded
    private Timestamp timeId;

    @OneToMany(fetch =FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    public Operation(BankAccount account, Integer operation_id, Double cost, String name,Timestamp timeId ) {
        this.account = account;
        this.cost = cost;
        this.operation_id = operation_id;
        this.name = name;
        this.timeId=timeId;
    }

    public Operation() {

    }
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> category) {
        this.categories = category;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }


    public Timestamp getTimeId() {
        return timeId;
    }

    public void setTimeId(Timestamp timeId) {
        this.timeId = Timestamp.now();
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Integer operation_id) {
        this.operation_id = operation_id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
     return "Operation{" +
                "operation_id=" + operation_id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", account=" + account +
                ", timeId=" + timeId +
                '}';
    }
}