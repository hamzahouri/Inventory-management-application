package com.win.shop.Exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    private ErrorsCode errorsCode;
    @Getter
    private List<String> errors;

    public InvalidEntityException(ErrorsCode errorsCode, List<String> errors) {
        this.errorsCode = errorsCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, ErrorsCode errorsCode, List<String> errors) {
        super(message);
        this.errorsCode = errorsCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Throwable cause, ErrorsCode errorsCode, List<String> errors) {
        super(message, cause);
        this.errorsCode = errorsCode;
        this.errors = errors;
    }

    public InvalidEntityException(Throwable cause, ErrorsCode errorsCode, List<String> errors) {
        super(cause);
        this.errorsCode = errorsCode;
        this.errors = errors;
    }
}
