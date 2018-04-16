package cn.xx.platform.system.api.exception;


import cn.xx.platform.system.api.exception.base.BusinessException;

/**
 * 用户已存在
 *
 *
 */
public class UserExistException extends BusinessException {

    public UserExistException(String message) {
        super(message);
    }

}
