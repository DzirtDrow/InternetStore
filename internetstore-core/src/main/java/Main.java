import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.util.HibernateSessionFactory;
import com.tsystems.javaschool.brajnikov.internetstore.util.RoleEnum;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, 1);

//        UserEntity newUser = new UserEntity();
//        newUser.setName("bbb");
//        newUser.setLastName("bbb");
//        newUser.setPassword("bbb");
//        newUser.setDate(new Date());
//        newUser.setEmail("b@b.ru");
//        newUser.setRole(RoleEnum.admin);
//        session.save(newUser);
        System.out.println(userEntity);


        session.close();


    }
}