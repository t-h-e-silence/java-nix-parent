package finance.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operationId;
    private String name;
    private Double cost;
    private boolean profit;

    @ManyToOne( cascade = CascadeType.ALL)
    private BankAccount account;

    @Embedded
    private Timestamp timeId;

    @ManyToMany(fetch =FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    public Operation(boolean profit, BankAccount account, Double cost, String name,Timestamp timeId ) {
        this.account = account;
        this.cost = cost;
        this.name = name;
        this.timeId=timeId;
        this.profit=profit;
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

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operation_id) {
        this.operationId = operationId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public boolean isProfit() {
        return profit;
    }

    public void setProfit(boolean profit) {
        profit = profit;
    }


    @Override
    public String toString() {
     return "Operation{" +
                "operation_id=" + operationId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", account=" + account +
                ", timeId=" + timeId +
                '}';
    }
}