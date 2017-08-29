package com.lq.plat.link.utils.security;

import com.lq.plat.link.config.PlatformUser;
import com.lq.plat.link.security.Roles;
import com.lq.plat.link.user.InfoUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
public class UserSecurityUtils {
    public static InfoUser getInfoUser() {
        PlatformUser<InfoUser> ui = getPlatformUser();
        if (ui == null) {
            return null;
        }
        return (InfoUser) ui.getInfoUser();
    }

    public static PlatformUser<InfoUser> getPlatformUser() {
        PlatformUser<InfoUser> ui = SecurityUtils.currentUser();
        return ui;
    }

    public static Long getInfoUserId() {
        InfoUser ui = getInfoUser();
        if (ui == null) {
            return null;
        }
        return (Long) ui.getId();
    }


    public static boolean hasPlatformRole() {
        Collection<GrantedAuthority> gas = getPlatformUser().getAuthorities();
        for (GrantedAuthority ga : gas) {
            if (ga.getAuthority().endsWith(Roles.PLATFORM.name())) {
                return true;
            }
        }
        return false;
    }

}
