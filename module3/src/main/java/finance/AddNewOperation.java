package finance;

import finance.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class AddNewOperation {

    private static final Logger logger = LoggerFactory.getLogger(AddNewOperation.class);
 public int userId;
 int accountId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public  User userById(int id) {
        Configuration cf = new Configuration().configure();
        try (SessionFactory sessionFactory = cf.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {
            return session.get(User.class, id);
        } catch (Exception e) {
        }
        return null;
    }

    public  Collection<BankAccount> accountsList(int userId) {
        User user = userById(userId);
        Timestamp now = Timestamp.now();
        List<BankAccount> allUserAccountsList = (List<BankAccount>) user.getAccounts();
        System.out.println("ACCOUNTS" + allUserAccountsList.toArray().toString());
        return allUserAccountsList;

    }

    public  BankAccount accountById(int id) {
        List<BankAccount> allAccounts= (List<BankAccount>) accountsList(userId);
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getId() == id) {
                return allAccounts.get(i);
            }
        }
        return null;
    }

    public  void addOperation(int accountId, String name, boolean profit, Double cost, String categoryName) {
        List<BankAccount> allUserAccountsList = (List<BankAccount>) accountsList(userId);
        BankAccount bankAccount = accountById( accountId);
        Operation operation = new Operation(profit, bankAccount, cost, name, Timestamp.now());

        if (operation.isProfit()) {
            bankAccount.setBalance(bankAccount.getBalance() + operation.getCost());
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - operation.getCost());
        }
        if (operation.getCost() > bankAccount.getBalance()) {
            return;
        }
        Category category = new Category();
        category.setCategoryName(categoryName);
        operation.addCategory(category);
        bankAccount.getOperations().add(operation);
        Configuration cf = new Configuration().configure();
        try (SessionFactory sessionFactory = cf.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {
            try {
                session.beginTransaction();
                session.save(category);
                session.save(operation);
                session.saveOrUpdate(bankAccount);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }

    }
}
