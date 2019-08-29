package com.spring.fallback;

import com.spring.beans.user.UserInfo;
import com.spring.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/fallback/provider/api/user")
public class UserFallback implements IUserService{

    @Override
    public UserInfo queryUser(Integer userId) {
        System.out.println("--降级---");
        return null;
    }

    @Override
    public List<UserInfo> listUser() {
        System.out.println("--降级---");
        return null;
    }

    @Override
    public Integer save(UserInfo userInfo) {
        System.out.println("--降级---");
        return null;
    }

    @Override
    public Integer delete(Integer userId) {
        System.out.println("--降级---");
        return null;
    }
}
