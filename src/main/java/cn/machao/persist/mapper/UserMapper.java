package cn.machao.persist.mapper;

import cn.machao.persist.model.User;

import java.util.List;

public interface UserMapper {

    int insert(User record);

    int deleteByUserId(int userId);

    int updateByUserId(User user);

    User getUserById(int userId);

    List<User> getAllUsers();
}
