package com.spring.beans.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Response<T> {

    private T data;

    private String message;

    private int code;
}
