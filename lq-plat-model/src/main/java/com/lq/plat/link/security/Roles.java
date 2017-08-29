package com.lq.plat.link.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/30
 */
public enum Roles {
    PLATFORM, ADMIN, MANAGER, USER, MEMBER;

    private Roles() {
    }

    public static Roles getMaxRole(Collection<? extends GrantedAuthority> gas) {

        for (Roles r : values()) {
            for (GrantedAuthority ga : gas) {
                if (ga.getAuthority().indexOf(r.name()) != -1) {
                    return r;
                }
            }
        }
        return null;
    }

    public static Set<Roles> getRoles(Set<Roles> set) {
        Set<Roles> rset = Sets.newLinkedHashSet();
        for (Roles roles : set) {
            rset.addAll(getRoles(roles));
        }
        return rset;
    }

    public static Set<Roles> getRoles(Roles role) {
        Set<Roles> set = Sets.newLinkedHashSet();
        boolean flag = false;
        for (Roles r : values()) {
            if (role.equals(r)) {
                flag = true;
            }
            if (flag) {
                set.add(r);
            }
        }
        return set;
    }
}
