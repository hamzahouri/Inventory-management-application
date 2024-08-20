package com.win.shop.Exception;

public enum ErrorsCode {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_Valid(1001),
    CATEGORY_NOT_FOUND(2000),
    COMMAND_CLIENT_NOT_VALID(2001),
    COMMAND_CLIENT_NOT_FOUND(2003),
    ENTREPRISE_NOT_FOUND(3000),
    FOURNISSEUR_NOT_FOUND(4000),
    CLIENT_NOT_FOUND(5000);

    private int code;

    ErrorsCode (int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
