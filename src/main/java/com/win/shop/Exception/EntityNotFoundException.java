package com.win.shop.Exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorsCode errorsCode;

    public EntityNotFoundException(ErrorsCode errorsCode) {
        this.errorsCode = errorsCode;
    }

    public EntityNotFoundException(String message, ErrorsCode errorsCode) {
        super(message);
        this.errorsCode = errorsCode;
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorsCode errorsCode) {
        super(message, cause);
        this.errorsCode = errorsCode;
    }

    public EntityNotFoundException(Throwable cause, ErrorsCode errorsCode) {
        super(cause);
        this.errorsCode = errorsCode;
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorsCode errorsCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorsCode = errorsCode;
    }
}
