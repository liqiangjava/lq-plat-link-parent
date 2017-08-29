package com.lq.plat.link.utils.security;

import com.lq.plat.link.config.PlatformUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
public class SecurityUtils {
    public static <T> PlatformUser<T> currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        if ((auth instanceof AnonymousAuthenticationToken)) {
            return null;
        }
        return (PlatformUser) auth.getPrincipal();
    }

}
