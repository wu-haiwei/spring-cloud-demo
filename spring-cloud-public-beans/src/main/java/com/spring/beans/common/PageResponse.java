package com.spring.beans.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageResponse<T> {

    private List<T> data;

    private String message;

    private int code;

    private int total;
}
