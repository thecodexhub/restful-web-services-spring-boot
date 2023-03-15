package dev.thecodexhub.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

  private static List<User> users = new ArrayList<>();

  private static int usersCount = 3;

  static {
    users.add(new User(++usersCount, "Sandip", LocalDate.now().minusYears(23)));
    users.add(new User(++usersCount, "Julie", LocalDate.now().minusYears(27)));
    users.add(new User(++usersCount, "Morgan", LocalDate.now().minusYears(20)));
  }

  public List<User> findAll() {
    return users;
  }

  public User save(User user) {
    user.setId(++usersCount);
    users.add(user);
    return user;
  }

  public User findOne(int id) {
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    return users.stream().filter(predicate).findFirst().orElse(null);
  }

  public void deleteById(int id) {
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    users.removeIf(predicate);
  }
}
