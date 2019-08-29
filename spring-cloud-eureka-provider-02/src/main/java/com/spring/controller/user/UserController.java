package com.spring.controller.user;


import com.spring.beans.user.UserInfo;
import com.spring.interfaces.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider/api/user")
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/detail/{userId}")
    public UserInfo queryUser(@PathVariable("userId") Integer userId) {
        return userInfoService.queryBuId(userId);
    }

    @GetMapping("/list")
    public List<UserInfo> listUser() {
        return userInfoService.list();
    }

    @PostMapping("/save")
    public Integer save(@RequestBody UserInfo userInfo) {
        return userInfoService.insert(userInfo);
    }

    @DeleteMapping("/delete/{userId}")
    public Integer delete(@PathVariable("userId") Integer userId) {
        return userInfoService.delete(userId);
    }
}
