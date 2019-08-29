package com.spring.controller.user;

import com.spring.beans.common.PageResponse;
import com.spring.beans.common.Response;
import com.spring.beans.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final String PROVIDER_SERVICE = "http://127.0.0.1:8000/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/detail/{userId}")
    public Response<UserInfo> queryUser(@PathVariable("userId") Integer userId) {
        String url = PROVIDER_SERVICE + "api/user/detail/" + userId;
        UserInfo info = restTemplate.getForObject(url, UserInfo.class);
        Response<UserInfo> response = new Response<>();
        response.setData(info);
        return response;
    }

    @GetMapping("/list")
    public PageResponse<UserInfo> listUser() {
        String url = PROVIDER_SERVICE + "api/user/list";
        List<UserInfo> infos = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserInfo>>() {
        }).getBody();
        PageResponse<UserInfo> response = new PageResponse<>();
        response.setData(infos);
        return response;
    }

    @PostMapping("/save")
    public Response<Integer> save(@RequestBody UserInfo userInfo) {
        String url = PROVIDER_SERVICE + "api/user/save";
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, userInfo, Integer.class);
        Response<Integer> response = new Response<>();
        response.setData(responseEntity.getBody());
        return response;
    }

    @DeleteMapping("/delete/{userId}")
    public Response<Integer> save(@PathVariable("userId") Integer userId) {
        String url = PROVIDER_SERVICE + "api/user/delete/" + userId;
        restTemplate.delete(url);
        return new Response<>();
    }
}
