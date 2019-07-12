package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor  implements HandlerInterceptor {
    //在目标方法执行前 执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("preHandle...");
        //返回值：true 表示放行， false： 表示拦截
        return true;
    }
    //在目标方法执行之后，视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView){
        //只有preHandle方法返回true是，该方法才会执行，可以对结果进行怎强
        System.out.println("postHandle..");
    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex){

    }
}
