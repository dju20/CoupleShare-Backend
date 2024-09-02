package com.example.couplesharebackend.exception.user;

public class LoginUserException extends RuntimeException{
    public LoginUserException(){
        super("로그인 사용자 정보를 찾을 수 없습니다");
    }

    public LoginUserException(String message){
        super(message);
    }
}
