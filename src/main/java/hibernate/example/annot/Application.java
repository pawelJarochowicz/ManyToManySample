package hibernate.example.annot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        City city1=new City();
        city1.setName("Minnesota");
        city1.setPopulation(1565.00);
        session.save(city1);

        City city2=new City();
        city2.setName("Nashville");
        city2.setPopulation(976.50);
        session.save(city2);

        City city3=new City();
        city3.setName("Boston");
        city3.setPopulation(2458.70);
        session.save(city3);

        User user1=new User();
        user1.setName("Harry");
        user1.setAge(36);
        user1.getCities().add(city1);
        session.save(user1);

        User user2=new User();
        user2.setName("Alec");
        user2.setAge(26);
        user2.getCities().add(city1);
        session.save(user2);

        User user3=new User();
        user3.setName("Derick");
        user3.setAge(54);
        user2.getCities().add(city2);
        session.save(user3);

        User user4=new User();
        user4.setName("Russell");
        user4.setAge(20);
        session.save(user4);

        City city4=new City();
        city4.setName("Seattle");
        city4.setPopulation(1987.45);
        city4.getUsers().add(user4);
        session.save(city4);

        transaction.commit();
        session.close();
        System.out.println("ALL DONE. SUCCESS");

    }

}
