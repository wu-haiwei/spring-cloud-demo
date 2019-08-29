package com.spring.interfaces.user;

import com.spring.beans.user.UserInfo;

import java.util.List;

public interface IUserInfoService {

    List<UserInfo> list();

    UserInfo queryBuId(Integer userId);

    Integer insert(UserInfo userInfo);

    Integer delete(Integer userId);
}
