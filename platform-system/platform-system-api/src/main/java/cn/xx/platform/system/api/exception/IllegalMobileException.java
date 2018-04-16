package cn.xx.platform.system.api.exception;


import cn.xx.platform.system.api.exception.base.BusinessException;

/**
 * 手机号码不合法
 *
 *
 */
public class IllegalMobileException extends BusinessException {

    public IllegalMobileException(String message) {
        super(message);
    }

}
