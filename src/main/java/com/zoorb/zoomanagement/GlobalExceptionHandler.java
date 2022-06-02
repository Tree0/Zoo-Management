package com.zoorb.zoomanagement;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler({Exception.class})
    // public String myExceptionHandler() {
    //     return "error.html";
    // }

    @ExceptionHandler({Exception.class})
    public ModelAndView myExceptionHandlerV2(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error-detailed");
        mv.addObject("errorMessage",ex.getMessage());
        return mv;
    }

    // @ExceptionHandler({NullPointerException.class})
    // public String myExceptionHandler1() {
    //     return "error.html";
    // }
    
}
