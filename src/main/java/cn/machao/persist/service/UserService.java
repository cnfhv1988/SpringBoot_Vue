package cn.machao.persist.service;

import cn.machao.persist.model.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> findAllUsers();

    int deleteUser(int userId);

    int updateUser(User user);

    User getUserById(int userId);
}
