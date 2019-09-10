package com.study.extend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BasicAjaxController extends BaseAbstractController implements Cloneable,BeanNameAware{

    Log logger = LogFactory.getLog(this.getClass());

    protected String beanName;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        logger.info("BasicController ~!");
        BasicAjaxController controller = null;
        try {
            controller = (BasicAjaxController)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        controller.execute(request,response);

        return null;
    }

    public abstract String execute(HttpServletRequest request, HttpServletResponse response);


    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
