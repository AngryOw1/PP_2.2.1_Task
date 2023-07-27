package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("Вася", "Патриот", "niva4x4niva@mail.ru","lada", 2121));
      userService.add(new User("Shin", "Chan", "shin_4an@mail.ru","mazda", 3));
      userService.add(new User("Петя", "Ровный", "petr_r@mail.ru","lada", 2107));
      userService.add(new User("Коля", "Крутой", "kolyan22@mail.ru","bmw", 3));

      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      users.forEach(System.out::println);

      System.out.println(userService.findOwnerCar("lada", 2107));
      System.out.println(userService.findOwnerCar("lada", 2121));
      System.out.println(userService.findOwnerCar("bmw", 3));
      System.out.println(userService.findOwnerCar("mazda", 3));

      context.close();
   }
}
