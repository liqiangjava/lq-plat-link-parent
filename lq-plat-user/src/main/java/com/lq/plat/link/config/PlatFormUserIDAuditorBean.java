package com.lq.plat.link.config;

import com.lq.plat.link.utils.security.UserSecurityUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * createUser赋值
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/16
 */
public class PlatFormUserIDAuditorBean implements AuditorAware<Long> {
    @Override
    public Long getCurrentAuditor() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            return null;
        }
        if (ctx.getAuthentication() == null) {
            return null;
        }
        if (ctx.getAuthentication().getPrincipal() == null) {
            return null;
        }
        Long id = UserSecurityUtils.getInfoUserId();
        return id;
    }
}
