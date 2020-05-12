package finance.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @Column(nullable = false)
    private Username username;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private final List<BankAccount> accounts = new ArrayList<>();


    public User( Username username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getUsername().equals(user.getUsername()) &&
                getAccounts().equals(user.getAccounts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getAccounts());
    }

    StringBuilder printacc(){
        StringBuilder acc = new StringBuilder(" ");
        for (int i = 0; i <accounts.size(); i++) {
            acc.append(
            " \n id= "+
                    accounts.get(i).getId().toString()+
                    ", \n balance=" + accounts.get(i).getBalance().toString() +
                    '}');
        }
        return acc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id.intValue() +
                ", username=" + username +
                ", accounts=" + printacc() +
                '}';
    }
}