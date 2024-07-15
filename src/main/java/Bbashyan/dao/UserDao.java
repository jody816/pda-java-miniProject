package Bbashyan.dao;

import Bbashyan.model.Bucket;
import Bbashyan.model.Category;
import Bbashyan.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    private static final Map<String, User> map = new HashMap<>();

    public User findUserById(String id) {
        return map.getOrDefault(id, User.builder().password("").build());
    }

    // TODO: 아이디 중복 처리 필요
    public void save(User user) {
        map.put(user.getId(), user);
    }

}
