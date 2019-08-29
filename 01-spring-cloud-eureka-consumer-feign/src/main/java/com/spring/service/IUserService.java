package com.spring.service;

import com.spring.beans.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient("SPRING-CLOUD-EUREKA-PROVIDER-01")
@RequestMapping("/provider/api/user")
public interface IUserService {

    @GetMapping("/detail/{userId}")
    UserInfo queryUser(@PathVariable("userId") Integer userId);

    @GetMapping("/list")
    List<UserInfo> listUser();

    @PostMapping("/save")
    Integer save(@RequestBody UserInfo userInfo);

    @DeleteMapping("/delete/{userId}")
    Integer delete(@PathVariable("userId") Integer userId);
}
