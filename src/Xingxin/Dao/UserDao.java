package Xingxin.Dao;

import Xingxin.Object.User;

import java.util.List;

/**
 * @author 231
 * @date 2020-06-18 23:46
 */
public interface UserDao {
    List<User> getUser (User user);

    List<User> getAnswer (User user);

    int addUser(User user);

    int addQuestion(User user);

    int update(User user);
}
