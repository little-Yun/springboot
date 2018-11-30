package com.xy.study.extend;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class BaseAjaxController {

    Log logger = LogFactory.getLog(this.getClass());

    public boolean before(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        Map<String,Object> map = new HashMap<>();
        if(null != cookies){
            for (Cookie cookie: cookies) {
                if(cookie == null) continue;
                map.put(cookie.getName(),cookie.getValue());
            }
        }


        // 单点登陆检查
        boolean isLoggin = MapUtils.getBooleanValue(map,"logInfo");
        logger.info("check isLoggin:" + isLoggin);

        return  isLoggin;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response){
        // 子类继承

        return null;
    }
}
