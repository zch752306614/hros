package com.alice.hros.Exception;


import org.springframework.security.core.AuthenticationException;


/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/18 7:24
 */

public class ValidateCodeException extends AuthenticationException  {

    public ValidateCodeException(String msg) {
        super(msg);
    }


}
