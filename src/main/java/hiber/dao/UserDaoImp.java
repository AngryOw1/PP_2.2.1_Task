package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

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
   public User findOwnerCar(String model_car, int series_car) {
      Query ownerCarQuery = sessionFactory.getCurrentSession().createQuery("from Car where model = :model_car and series = :series_car")
              .setParameter("model_car", model_car)
              .setParameter("series_car", series_car);

      Car userCar = (Car) ownerCarQuery.getSingleResult();

      User userResult = listUsers().stream()
              .filter(user -> user.getCar() != null)
              .filter(user -> user.getCar().equals(userCar))
              .findAny()
              .orElse(null);

      return userResult;
   }
}
