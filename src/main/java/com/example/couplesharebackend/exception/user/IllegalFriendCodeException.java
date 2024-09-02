package com.example.couplesharebackend.exception.user;

public class IllegalFriendCodeException extends RuntimeException {
    public IllegalFriendCodeException() {
        super("유효하지 않은 친구 코드입니다");

    }

    public IllegalFriendCodeException(String message) {
        super(message);
    }
}
