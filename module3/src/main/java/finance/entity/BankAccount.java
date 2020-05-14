package finance.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

    @Entity
    @Table(name = "account")
    public class BankAccount implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private Double balance;

        @ManyToOne
        @JoinColumn(name = "userId")
        private User user;

        @OneToMany(fetch =FetchType.EAGER, mappedBy = "account")
        private final List<Operation> operations = new ArrayList<>();


        public BankAccount() {
        }

        public List<Operation> getOperations() {
            return operations;
        }

        public BankAccount(Integer id, Double balance, User user) {
            this.id = id;
            this.balance = balance;
            this.user = user;
        }
        public void addOperation(Operation operation) {
            operations.add(operation);
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Double getBalance() {
            return balance;
        }

        public void setBalance(Double balance) {
            this.balance = balance;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }


        @Override
        public String toString() {
            return "BankAccount{" +
                    "id=" + id +
                    ", balance=" + balance +
                    ", user=" + user +
                    ", operations=" + stringBuilder() +
                    '}';
        }

        public StringBuilder stringBuilder(){
        StringBuilder acc = new StringBuilder(" ");
        for (int i = 0; i <operations.size() ; i++) {
            acc.append(
                    " id= "+operations.get(i).getOperationId()+
                            "\n name= "+ operations.get(i).getName()+
                            ", \n cost= " + operations.get(i).getCost()+ " "+
                            ", \n category= " + operations.get(i).getCategories().size()+
                            " " +operations.get(i).getTimeId().toString()+
                            '}');
        }
        return acc;
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BankAccount)) return false;
            BankAccount account = (BankAccount) o;
            return getId().equals(account.getId()) &&
                    getBalance().equals(account.getBalance()) &&
                    getUser().equals(account.getUser());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getBalance(), getUser());
        }
    }

