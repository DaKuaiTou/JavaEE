package com.dkt.util;

import javax.servlet.http.Cookie;

/**
 * @author: dkt
 * @Pcakage: com.dkt.util.CookieUtil
 * @Date: 2022年09月21日 10:25
 * @Description:
 */
public class CookieUtil {
    // 创建cookie
    public static Cookie createAndSetCookie(String key,String value,int time, String path){
        Cookie cookie = new Cookie(key,value);
        // 定义cookie的有效期
        cookie.setMaxAge(time);
        // 定义cookie的有效路径
        cookie.setPath(path);
        return cookie;
    }

    // 根据cookie的key获取value
    public static String getCookieValue(Cookie[] cookies,String key){
        String value = null;
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equalsIgnoreCase(key)){
                     value = cookie.getValue();
                }
            }
        }
        return value;
    }
}
