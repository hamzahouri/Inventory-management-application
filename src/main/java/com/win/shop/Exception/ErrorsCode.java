package com.win.shop.Exception;

public enum ErrorsCode {

    ARTICLE_NOT_FOUND(1000),
    CATEGORY_NOT_FOUND(2000),
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
