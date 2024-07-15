package Bbashyan.service.user;

import Bbashyan.dao.user.UserDao;
import Bbashyan.model.bucket.Bucket;
import Bbashyan.model.user.User;

import java.util.NoSuchElementException;

public class UserService {
    private final UserDao userDao = new UserDao();


    public void signUp(String id, String name, String password, String address) {
        User user = User.builder()
                .id(id)
                .name(name)
                .password(password)
                .address(address)
                .bucket(new Bucket())
                .credit(0)
                .build();
        userDao.save(user);
    }

    public User login(String id, String password) {
        User user = userDao.findUserById(id);
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new NoSuchElementException("***** 로그인 실패 *****");
    }

    public void update(User user) {
        userDao.update(user);
    }

}
