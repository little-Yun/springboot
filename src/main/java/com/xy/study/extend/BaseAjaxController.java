package com.xy.study.extend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseAjaxController extends HandlerInterceptorAdapter {

    Log logger = LogFactory.getLog(this.getClass());


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("BaseAjaxController prehandle~!");

        execute(request, response);

        return super.preHandle(request, response, handler);
    }

    /**
     * 登陆检查
     * @param request
     * @return
     */
    protected boolean before(HttpServletRequest request){
     return  true;
    }

    // 子类方法重写
    protected abstract String execute(HttpServletRequest request, HttpServletResponse response);


    private void processresult(HttpServletResponse response,String resultMessage) throws IOException {
        response.getWriter().write(resultMessage);
        response.setContentType("text/html;charset=UTF-8");
    }
}
