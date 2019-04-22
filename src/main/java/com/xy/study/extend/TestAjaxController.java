package com.xy.study.extend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class TestAjaxController extends BasicAjaxController {

    Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping("/Ajax/test")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info("controller~!");

        return "success!";
    }
}
