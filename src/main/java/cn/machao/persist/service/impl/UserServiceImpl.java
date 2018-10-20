package cn.machao.persist.service.impl;

import cn.machao.persist.mapper.UserMapper;
import cn.machao.persist.model.User;
import cn.machao.persist.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public PageInfo<User> findAllUsers(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteByUserId(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByUserId(user);
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }
}
