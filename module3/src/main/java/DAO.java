import finance.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DAO {
    private Configuration cf = new Configuration().configure();
    private static final Logger log = LoggerFactory.getLogger(DAO.class);

    public User userById(int id) {
        try (SessionFactory sessionFactory = cf.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {
            return session.get(User.class, id);
        } catch (Exception e) {
        }
        return null;
    }

    public Collection<BankAccount> accountsForUser(int id) {
        User user = userById(id);
        try (SessionFactory sessionFactory = cf.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {
            List<BankAccount> allAccuonts = session.createQuery("from BankAccount order by id").list();
            session.getTransaction().commit();
            return allAccuonts;
        }
    }

    public BankAccount accountById(List<BankAccount> allAccounts, int id) {
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getId() == id) {
                return allAccounts.get(i);
            }
        }
        return null;
    }

    public void addOperation(int id) {
        try (SessionFactory sessionFactory = cf.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {
            User user = userById(id);
            session.beginTransaction();
            List<BankAccount> allUserAccounts = new ArrayList<>();
            System.out.println("Enter account id: ");
            int account_id = 2;
            BankAccount bankAccount = accountById(allUserAccounts, account_id);
            Double cost = 1222.00;
            String name = "last operarion";
            Operation operation = new Operation(bankAccount, bankAccount.getOperations().size() + 1,
                    cost, name, Timestamp.now());
            session.save(operation);
            session.getTransaction().commit();
            // log.info("Session created");

        } catch (Exception e) {
            //   log.info("\n Session error ", e);
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        User user = dao.userById(1);
      //  dao.addOperation(1);

        System.out.println("\n\n\n\nCatch begin \n\n\n");
        List<BankAccount> allUserAccounts = new ArrayList<>();
    allUserAccounts=user.getAccounts();
        System.out.println("Enter account id: ");
        int account_id = 2;
        BankAccount bankAccount = dao.accountById(allUserAccounts, account_id);
        Double cost = 1222.00;
        String name = "last operation";
        Timestamp now = Timestamp.now();
       ArrayList< Operation> operation = new ArrayList<>();
       operation.add(new Operation(bankAccount, bankAccount.getOperations().size()+1,
                cost, name, Timestamp.now()));
        Category category= new Category(operation, 3, "new category");
        System.out.println("\n\n\n\nCatch it \n\n\n");

        Configuration cf = new Configuration().configure();
        try (SessionFactory sessionFactory = cf.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {    System.out.println("\n\n\n\nCatch session \n\n\n");
            try {
                System.out.println("\n\n\n\nTRANSACTION \n\n\n");
                operation.get(operation.size()).addCategory(category);
                bankAccount.addOperation(operation.get(operation.size()));
                System.out.println("\n\n\n\npretransaction begin \n\n\n");
                session.beginTransaction();
                System.out.println("\n\n\n\ntransaction begin \n\n\n");
                session.save(category);
                System.out.println("\n\n\n\ntransaction category \n\n\n");
                session.save(operation);
                System.out.println("\n\n\n\ntransaction operation \n\n\n");
                session.saveOrUpdate(bankAccount);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("\n\n\n\nPROBLEMS!!!!!!!!!!!!!!!!!!!!!! \n\n\n");
                session.getTransaction().rollback();
            }
        }

    }
}
