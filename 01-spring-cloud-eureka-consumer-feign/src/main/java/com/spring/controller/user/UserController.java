package com.spring.controller.user;

import com.spring.beans.common.PageResponse;
import com.spring.beans.common.Response;
import com.spring.beans.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/detail/{userId}")
    public Response<UserInfo> queryUser(@PathVariable("userId") Integer userId) {
        UserInfo info = userService.queryUser(userId);
        Response<UserInfo> response = new Response<>();
        response.setData(info);
        return response;
    }

    @GetMapping("/list")
    public PageResponse<UserInfo> listUser() {
        List<UserInfo> infos = userService.listUser();
        PageResponse<UserInfo> response = new PageResponse<>();
        response.setData(infos);
        return response;
    }

    @PostMapping("/save")
    public Response<Integer> save(@RequestBody UserInfo userInfo) {
        Response<Integer> response = new Response<>();
        response.setData(userService.save(userInfo));
        return response;
    }

    @DeleteMapping("/delete/{userId}")
    public Response<Integer> delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return new Response<>();
    }
}
