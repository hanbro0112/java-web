package com.sky.exception;

/**
 * 帳戶不存在
 */
public class AccountNotFoundException extends BaseException {

    public AccountNotFoundException() {}

    public AccountNotFoundException(String message) {
        super(message);
    }
}
