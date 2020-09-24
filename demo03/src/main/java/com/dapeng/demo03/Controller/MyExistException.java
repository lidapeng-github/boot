package com.dapeng.demo03.Controller;


import com.dapeng.demo03.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExistException {
  /*  @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object>  hanleException(Exception e){

        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("msg",e.getMessage());
            return map;
    }
*/

    @ExceptionHandler(UserNotExistException.class)
    public String  hanleException(Exception e, HttpServletRequest request){
        //传入我们自己的错误状态码 4xx 5xx
        // Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        request.setAttribute("javax.servlet.error.status_code",400);
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("msg",e.getMessage());
        return  "forward:/error";
    }
}
