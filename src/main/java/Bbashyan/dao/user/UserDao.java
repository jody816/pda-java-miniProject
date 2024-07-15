package Bbashyan.dao.user;

import Bbashyan.model.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserDao {
    private static final Map<String, User> userRepository = new HashMap<>();

    public User findUserById(String id) {
        return userRepository.getOrDefault(id, User.builder().password("").build());
    }

    public void save(User user) {
        if (userRepository.getOrDefault(user.getId(), null) == null) {
            userRepository.put(user.getId(), user);
            return;
        }
        throw new NoSuchElementException("***** 유저가 이미 있습니다. *****");
    }

    public void update(User user) {
        userRepository.put(user.getId(), user);
    }

}
