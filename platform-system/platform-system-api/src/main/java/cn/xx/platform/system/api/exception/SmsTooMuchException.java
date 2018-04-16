package cn.xx.platform.system.api.exception;


import cn.xx.platform.system.api.exception.base.BusinessException;

/**
 * 短信发送太频繁
 *
 *
 */
public class SmsTooMuchException extends BusinessException {

    public SmsTooMuchException(String message) {
        super(message);
    }

}
