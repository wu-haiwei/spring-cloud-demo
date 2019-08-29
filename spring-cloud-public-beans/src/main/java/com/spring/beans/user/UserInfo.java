package com.spring.beans.user;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfo {

    private Integer userId;

    private String userName;

    private String mobile;

    private Integer age;
}
