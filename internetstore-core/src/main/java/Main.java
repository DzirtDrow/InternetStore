import com.tsystems.javaschool.brajnikov.internetstore.controller.AppController;
import com.tsystems.javaschool.brajnikov.internetstore.dao.UserDaoImpl;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.util.HibernateSessionFactory;
import com.tsystems.javaschool.brajnikov.internetstore.util.RoleEnum;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

    }
}