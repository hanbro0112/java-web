package com.sky.exception;

/**
 * 帳戶鎖定
 */
public class AccountLockException extends BaseException {

    public AccountLockException() {}

    public AccountLockException(String message) {
        super(message);
    }
}
