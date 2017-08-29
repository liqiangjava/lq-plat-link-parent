package com.lq.plat.link.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 平台用户
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/8
 */
public class PlatformUser<T> extends User implements UserDetails {


    private static final long serialVersionUID = -7864800463884738504L;


    private final T infoUser;

    public PlatformUser(String username, String password, Collection<? extends GrantedAuthority> authorities, T infoUser) {
        super(username, password,  authorities);
        this.infoUser = infoUser;
    }

    public T getInfoUser() {
        return (T) this.infoUser;
    }

}
