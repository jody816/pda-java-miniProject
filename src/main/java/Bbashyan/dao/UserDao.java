package Bbashyan.dao;

import Bbashyan.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

  private static final Map<String, User> map = new HashMap<>();

  public User findUserById(String id) {
    return map.getOrDefault(id, User.builder().password("").build());
  }

  // todo 아이디 중복 처리 필요
  public void save(User user) {
    map.put(user.getId(), user);
  }

}
