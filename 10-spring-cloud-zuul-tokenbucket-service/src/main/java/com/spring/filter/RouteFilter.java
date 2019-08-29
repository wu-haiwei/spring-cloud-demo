package com.spring.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RouteFilter extends ZuulFilter {

    /**
     * 每秒产生3个令牌
     */
    private static RateLimiter RATE_LIMITER = RateLimiter.create(3);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 系统最小为 -3 , 越小越在前面执行
        return -5;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        if (!RATE_LIMITER.tryAcquire()) {
            log.warn("访问量超载");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(429);
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("通过过滤");
        return null;
    }
}
