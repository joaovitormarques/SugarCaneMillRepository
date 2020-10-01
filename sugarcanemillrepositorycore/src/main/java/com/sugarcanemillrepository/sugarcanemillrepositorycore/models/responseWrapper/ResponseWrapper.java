package com.sugarcanemillrepository.sugarcanemillrepositorycore.models.responseWrapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper<T> {

    private int code;

    private String message;

    private T data;

    public ResponseWrapper(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
