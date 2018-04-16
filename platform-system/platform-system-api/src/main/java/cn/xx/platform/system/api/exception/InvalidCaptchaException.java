package cn.xx.platform.system.api.exception;


import cn.xx.platform.system.api.exception.base.BusinessException;

/**
 * 无效验证码
 *
 *
 */
public class InvalidCaptchaException extends BusinessException {

    public InvalidCaptchaException(String message) {
        super(message);
    }

}
