package cn.xx.platform.mobile.client.security;

import cn.xx.platform.mobile.client.security.model.AuthUserFactory;
import cn.xx.platform.system.api.entity.TripUser;
import cn.xx.platform.system.api.service.ITripUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Security User Detail Service
 *
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户服务
     */
    @Autowired
    private ITripUserService tripUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) {
        TripUser user = tripUserService.getByMobile(loginName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
        } else {
            return AuthUserFactory.create(user);
        }
    }
}
