package cn.machao.persist.controller;

import cn.machao.persist.model.User;
import cn.machao.persist.service.UserService;
import cn.machao.persist.utils.ResponseUtil;
import cn.machao.persist.utils.common.CommonResponse;
import cn.machao.persist.utils.common.Constant;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return ResponseUtil.generateResponse(Constant.RESPONSE_ERROR, Constant.DEFAULT_ERROR_MESSAGE, errors);
        }
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS, Constant.DEFAULT_SUCCESS_MESSAGE, userService.addUser(user));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS,Constant.DEFAULT_SUCCESS_MESSAGE,user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return ResponseUtil.generateResponse(Constant.RESPONSE_ERROR, Constant.DEFAULT_ERROR_MESSAGE, errors);
        }
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS,Constant.DEFAULT_SUCCESS_MESSAGE,userService.updateUser(user));
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllUsers(Integer pageNum, Integer pageSize) {
        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = Constant.ROWS_PER_PAGE;
        }
        logger.info("pageNum:" + pageNum + ",pageSize:" + pageSize);
        PageInfo<User> users = userService.findAllUsers(pageNum, pageSize);
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS,Constant.DEFAULT_SUCCESS_MESSAGE,users);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public CommonResponse deleteUser(@PathVariable int userId) {
        return ResponseUtil.generateResponse(Constant.RESPONSE_SUCCESS, Constant.DEFAULT_SUCCESS_MESSAGE, userService.deleteUser(userId));
    }

}
