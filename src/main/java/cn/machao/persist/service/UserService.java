package cn.machao.persist.service;

import cn.machao.persist.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUsers(Integer pageNum, Integer pageSize);

    int deleteUser(int userId);

    int updateUser(User user);

    User getUserById(int userId);
}
