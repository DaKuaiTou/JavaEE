package com.dkt.Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author: dkt
 * @Pcakage: com.dkt.Listener.CountListener
 * @Date: 2022年12月07日 12:01
 * @Description:
 */
public class CountListener implements HttpSessionListener {
    int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session is created");
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(30);
        ServletContext servletContext = session.getServletContext();
        Object obj = servletContext.getAttribute("count");
        if(obj == null){
            count = 1;
        } else {
            int currCount = Integer.parseInt(obj.toString());
            count = currCount+1;
        }
        servletContext.setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session is Destroyed");
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(30);
        ServletContext servletContext = session.getServletContext();
        Object obj = servletContext.getAttribute("count");
        int currCount = Integer.parseInt(obj.toString());
        if(currCount <= 0){
            count = 1;
        } else {
            count = count-1;
        }
        servletContext.setAttribute("count",count);
    }
}
