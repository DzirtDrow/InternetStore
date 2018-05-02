import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.util.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, 1);

        session.close();
        System.out.println(userEntity);

    }
}