package cn.xx.platform.system.api.exception;


import cn.xx.platform.system.api.exception.base.BusinessException;

/**
 * 用户未存在
 *
 *
 */
public class UserNotExistException extends BusinessException {

    public UserNotExistException(String message) {
        super(message);
    }

}
