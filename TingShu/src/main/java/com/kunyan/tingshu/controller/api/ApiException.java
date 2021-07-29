package com.kunyan.tingshu.controller.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends Exception {
    private int code;
    private String reason;

    public ApiException(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public ApiException(int code, String reason, Throwable rootCause) {
        super(rootCause);
        this.code = code;
        this.reason = reason;
    }
}
