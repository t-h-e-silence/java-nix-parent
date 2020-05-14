import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import finance.entity.*;

import java.lang.management.OperatingSystemMXBean;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Menu {
  //  с

    public static void main(String[] args) {
        Timestamp now = Timestamp.now();

        Configuration cf = new Configuration().configure();
        try (SessionFactory sessionFactory = cf.buildSessionFactory();
             Session session = sessionFactory.openSession()
        ) {
            try {
            Transaction t= session.beginTransaction();

          /*      User u=new User(new Username("aanuefnk"));
                BankAccount n=new BankAccount(1, 2000.0, u);
                n.setOperation(new Operation());
                u.addAccount(n);
               // BankAccount standard = new BankAccount(1, 2300.7, u);
                //BankAccount standardplus = new BankAccount(11, 2300.7, u);
                //u.addAccount(standard);
                //u.addAccount(standard);
                List <Category> c=new ArrayList<>();
                c.add(new Category(now, "Salary"));
              //  Operation o=new Operation(1,standard, (List<Category>) c, 374.6, Instant.now());
            //    o.addCategory(c.get(0));
                session.save(u);
               // session.save(standard);
                //session.save(o);
                //session.save(c);
                User user=new User();
                user.setUsername(new Username("Jack Sparrow"));
                BankAccount b=new BankAccount();
                b.setBalance(250.6);
                b.setOperation(new Operation());
                user.addAccount(b);
                System.out.printf("", b);
                session.getTransaction().commit();*/
            } catch (Exception e) {
               // log.error("error when populating db with mock data", e);
                session.getTransaction().rollback();
            }
         User getted=session.get(User.class, 1);
            List<BankAccount> list=getted.getAccounts();
            for (int i = 0; i <list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
            /*
insert into users values (1, 'Peter Jackson');
insert into account values (1, 22000.0, 1),
                           (2, 3000.0, 1),
                           (3, 500.0, 1);
insert into category values (1, 'new shoes'),
                            (2, 'salary'),
                            (3, 'cafe');
insert into operations values (1, 1000.0, 'first operatin', '02.02.2001', 1),
                              (2, 1000.0, 'second operatin', '02.02.2001', 1);
insert into operations_category values (1,1);
insert into operations_category values (1,2);*/
        System.out.println("WE have:\n\n\n"+getted+"\n\n\n" );
            session.close();
        }
    }
}
