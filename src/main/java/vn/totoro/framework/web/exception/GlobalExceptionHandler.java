package vn.totoro.framework.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.totoro.framework.web.domain.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author linh.nguyen
 * @version 1.0
 * @classname GlobalExceptionHandler
 * @description Global exception handler
 * @date 12/10/2019
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /*Permission verification failed, if the request returns json for ajax, the normal request jump to the page*/
    @ExceptionHandler(AuthorizationException.class)
    public Object handleAuthorizationException(HttpServletRequest request, AuthorizationException e){
        //TODO implement code here
        return null;
    }
    /*Intercepting unknown runtime exceptions*/
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult handleException(HttpRequestMethodNotSupportedException e){
        return AjaxResult.error("Runtime exception: " + e.getMessage() + ",Log time: " + System.currentTimeMillis());
    }
    /*System exception*/
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e){
        return AjaxResult.error("Server error, please contact the administrator" + ",Log time: " + System.currentTimeMillis());
    }
    /*Business abnormal*/
    public AjaxResult businessException(){
        //TODO implement code here
        return null;
    }
    /*Demo mode exception*/
    public AjaxResult demoModeException(){
        //TODO implement code here
        return null;
    }
}
