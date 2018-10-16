package cn.machao.persist.controller.exception;


import cn.machao.persist.utils.ResponseUtil;
import cn.machao.persist.utils.common.CommonResponse;
import cn.machao.persist.utils.common.Constant;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse exception(Exception e) {

        return ResponseUtil.generateResponse(Constant.RESPONSE_INTERNAL_SERVER_ERROR, e.getMessage(), null);
    }
}