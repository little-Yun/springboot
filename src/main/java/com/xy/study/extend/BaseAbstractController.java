package com.xy.study.extend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public abstract class BaseAbstractController extends  AbstractController{

    @Autowired
    org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter adapter;

    public final ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
        return handleRequestInternal(request,response);
    }

    @Override
    protected abstract ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response);

}
