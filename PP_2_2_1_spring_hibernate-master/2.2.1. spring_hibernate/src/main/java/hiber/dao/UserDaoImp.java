package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void removeUserById(long id) {
      Session session = sessionFactory.openSession();
      Transaction transaction = session.getTransaction();
      try {
         transaction.begin();
         session.delete(session.get(User.class, id));
         transaction.commit();
         System.out.println("User " + id + " удален");
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      } finally {
         session.close();
      }
   }

   @Override
   public void cleanUsersTable() {
         List<User> users = listUsers();
         for (User user: users) {
            sessionFactory.getCurrentSession().delete(user);
         }
      }

   @Override
   public User findUserByCarModelAndCarSeries(String carModel, int carSeries){
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User users where users.carsId.model = :carModel and users.carsId.series = :carSeries")
              .setParameter("carModel", carModel).setParameter("carSeries", carSeries);
      return query.getSingleResult();
   }

}
