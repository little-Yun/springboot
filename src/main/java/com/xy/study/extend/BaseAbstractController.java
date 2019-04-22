package com.xy.study.extend;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseAbstractController extends  AbstractController{


    public final ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
        return handleRequestInternal(request,response);
    }

    @Override
    protected abstract ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response);

}
