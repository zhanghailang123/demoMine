package com.zhl.mine.handler;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * @description: 限流拦截器
 *  https://www.cnblogs.com/kevinblandy/p/13435990.html
 * @author: zhanghailang
 * @date: 2021/8/9 14:17
 */
public class RateLimiterIntercepter implements HandlerInterceptor {

    private final RateLimiter rateLimiter;

    public RateLimiterIntercepter(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 成功获取令牌
         */
        if (this.rateLimiter.tryAcquire()){
            return true;
        }

        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.getWriter().write("服务器繁忙");

        return false;
    }
}