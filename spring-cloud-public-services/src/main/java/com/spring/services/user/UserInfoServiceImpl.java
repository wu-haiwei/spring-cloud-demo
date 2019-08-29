package com.spring.services.user;

import com.spring.beans.user.UserInfo;
import com.spring.interfaces.user.IUserInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    private static Map<Integer, UserInfo> userData;

    private static int id;

    static {
        userData = new HashMap<>();
        userData.put(1, new UserInfo().setUserId(1).setUserName("萧炎").setMobile("18358579595").setAge(25));
        userData.put(2, new UserInfo().setUserId(2).setUserName("云芝").setMobile("18358579595").setAge(25));
        userData.put(3, new UserInfo().setUserId(3).setUserName("唐三").setMobile("18358579595").setAge(25));
        userData.put(4, new UserInfo().setUserId(4).setUserName("小舞").setMobile("18358579595").setAge(25));
        id = 5;
    }

    @Override
    public List<UserInfo> list() {
        List<UserInfo> list = new ArrayList<>(userData.size());
        userData.forEach((key, val) -> {
            list.add(val);
        });
        return list;
    }

    @Override
    public Integer insert(UserInfo userInfo) {
        userInfo.setUserId(id);
        userData.put(id, userInfo);
        return id++;
    }

    @Override
    public UserInfo queryBuId(Integer userId) {
        if (new Random().nextInt(10) > 5) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return userData.get(userId);
    }

    @Override
    public Integer delete(Integer userId) {
        UserInfo userInfo = userData.remove(userId);
        return userInfo == null ? 0 : 1;
    }
}
