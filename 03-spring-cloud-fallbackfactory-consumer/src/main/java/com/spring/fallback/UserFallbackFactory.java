package com.spring.fallback;

import com.spring.beans.user.UserInfo;
import com.spring.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFallbackFactory implements FallbackFactory<IUserService> {
    @Override
    public IUserService create(Throwable cause) {
        return new IUserService() {

            @Override
            public UserInfo queryUser(Integer userId) {
                System.out.println("服务降级---");
                return null;
            }

            @Override
            public List<UserInfo> listUser() {
                System.out.println("服务降级---");
                return null;
            }

            @Override
            public Integer save(UserInfo userInfo) {
                System.out.println("服务降级---");
                return null;
            }

            @Override
            public Integer delete(Integer userId) {
                System.out.println("服务降级---");
                return null;
            }
        };
    }
}
