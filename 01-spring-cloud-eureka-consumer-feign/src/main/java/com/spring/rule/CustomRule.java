package com.spring.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class CustomRule implements IRule {

    private ILoadBalancer lb;

    @Override
    public Server choose(Object key) {
        // TODO 实现逻辑
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
