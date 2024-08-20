package com.win.shop.Exception;

public enum ErrorsCode {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_Valid(1001),
    CATEGORY_NOT_FOUND(2000),
    COMMAND_CLIENT_NOT_VALID(2001),
    VENTE_NOT_VALID(2001),
    VENTE_NOT_FOUND(2087),
    COMMAND_Fournisseur_NOT_VALID(3011),
    COMMAND_Fournisseur_NOT_FOUND(3011),
    Founisseur_NOT_FOUND(3987),
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
