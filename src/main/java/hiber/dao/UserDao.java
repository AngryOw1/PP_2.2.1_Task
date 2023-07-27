package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User findOwnerCar(String model_car, int series_car);
}
