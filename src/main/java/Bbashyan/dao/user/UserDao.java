package Bbashyan.dao.user;

import Bbashyan.model.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserDao {
    private static final Map<String, User> map = new HashMap<>();

    public User findUserById(String id) {
        return map.getOrDefault(id, User.builder().password("").build());
    }

    public void save(User user) {
        if (map.getOrDefault(user.getId(), null) == null) {
            map.put(user.getId(), user);
            return;
        }
        throw new NoSuchElementException("***** User가 이미 있습니다 *****");
    }

    public void update(User user) {
        map.put(user.getId(), user);
    }

}
