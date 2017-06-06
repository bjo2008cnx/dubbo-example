package net.aimeizi.dubbo.controller;

import lombok.extern.slf4j.Slf4j;
import net.aimeizi.dubbo.context.LocalSessionHelper;
import net.aimeizi.dubbo.context.SessionInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @descirption
 * @Date 2017-04-26
 **/
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        System.out.println("preHandle  out");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setUserName((String) request.getSession().getAttribute("name"));
        LocalSessionHelper.setUserSessionInfo(sessionInfo); //放入SessionHolder中
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalSessionHelper.removeAll();
    }

}
