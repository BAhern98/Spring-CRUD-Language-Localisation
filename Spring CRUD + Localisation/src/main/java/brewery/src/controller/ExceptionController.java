/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brewery.src.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Brendan
 */
@ControllerAdvice
public class ExceptionController {
    
    
    
    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest req, Exception ex){
        System.out.println("request " + req.getRequestURL()+ " Threw An Exception "+ ex);
        return "/Error";
    }
    
}
