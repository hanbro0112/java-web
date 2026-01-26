package com.sky.exception;

/**
 * 密碼錯誤
 */
public class PasswordErrorException extends BaseException{

    public PasswordErrorException() {}

    public PasswordErrorException(String message) {
        super(message);
    }
}
