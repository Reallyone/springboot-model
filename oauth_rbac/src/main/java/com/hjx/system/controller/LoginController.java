package com.hjx.system.controller;

import com.hjx.common.controller.BaseController;
import com.hjx.common.model.CodeEnum;
import com.hjx.common.model.Result;
import com.hjx.system.model.User;
import com.hjx.system.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Api(value = "登录相关")
@Controller
@ControllerAdvice
public class LoginController extends BaseController implements ErrorController {

    private final static String ERROR_PATH = "/error";


    @Autowired
    private LoginService loginService;


    @ApiOperation(value = "默认页", httpMethod = "POST")
    @RequestMapping(value = "/index")
    @ResponseBody
    public Result index() {
        return new Result(CodeEnum.INDEX.getCode(), null);
    }

    @ApiOperation(value = "退出", httpMethod = "POST")
    @RequestMapping(value = "/logoutJSON")
    @ResponseBody
    public Result logoutJSON() {
        loginService.logoutJSON();
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "容器错误页", httpMethod = "POST")
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Result getStatus(HttpServletRequest request) {
        return new Result(loginService.getStatus(request), null);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public Result illegalArgumentException(IllegalArgumentException e) {
        return new Result(e.getMessage(), null);
    }

}
