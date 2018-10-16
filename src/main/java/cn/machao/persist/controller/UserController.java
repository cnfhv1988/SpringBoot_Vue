package cn.machao.persist.controller;

import cn.machao.persist.model.User;
import cn.machao.persist.service.UserService;
import cn.machao.persist.utils.ResponseUtil;
import cn.machao.persist.utils.common.CommonResponse;
import cn.machao.persist.utils.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addUser(@RequestBody User user) {
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS, Constant.DEFAULT_SUCCESS_MESSAGE, userService.addUser(user));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS,Constant.DEFAULT_SUCCESS_MESSAGE,user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateUser(@RequestBody User user) {
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS,Constant.DEFAULT_SUCCESS_MESSAGE,userService.updateUser(user));
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS,Constant.DEFAULT_SUCCESS_MESSAGE,users);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public CommonResponse deleteUser(@PathVariable int userId) {
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS, Constant.DEFAULT_SUCCESS_MESSAGE, userService.deleteUser(userId));
    }

}
