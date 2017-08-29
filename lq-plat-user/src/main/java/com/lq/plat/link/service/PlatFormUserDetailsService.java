package com.lq.plat.link.service;

import com.lq.plat.link.config.PlatformUser;
import com.lq.plat.link.repository.InfoUserRepository;
import com.lq.plat.link.repository.InfoUserRoleRepository;
import com.lq.plat.link.security.InfoRole;
import com.lq.plat.link.security.InfoUserRole;
import com.lq.plat.link.user.InfoUser;
import com.lq.plat.link.utils.ConstantParaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户认证服务类:用于对用户名与密码进行判断
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/28
 */
public  class PlatFormUserDetailsService implements UserDetailsService ,SocialUserDetailsService {

    @Autowired
    private InfoUserRepository infoUserRepository;

    @Autowired
    private InfoUserRoleRepository infoUserRoleRepository;

    @Override
    public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException {
        InfoUser infoUser = infoUserRepository.findByMobileOrEmail(username, ConstantParaUtil.USE);
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (!StringUtils.isEmpty(infoUser)) {
            List<InfoUserRole> infoUserRoles =
                    infoUser.getInfoUserRoles();
            for (InfoUserRole infoUserRole : infoUserRoles) {
                InfoRole infoRole = infoUserRole.getInfoRole();
                authorities.add(new SimpleGrantedAuthority(infoRole.getName()));
            }
            String name = getNameByLoginModel(infoUser);
            return new SocialUser(name, infoUser.getPassword(), authorities);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        InfoUser infoUser = infoUserRepository.findByMobileOrEmail(username, ConstantParaUtil.USE);
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (!StringUtils.isEmpty(infoUser)) {
            List<InfoUserRole> infoUserRoles =
                    infoUser.getInfoUserRoles();
            for (InfoUserRole infoUserRole : infoUserRoles) {
                InfoRole infoRole = infoUserRole.getInfoRole();
                authorities.add(new SimpleGrantedAuthority(infoRole.getName()));
            }
            String name = getNameByLoginModel(infoUser);
            return new PlatformUser(name, infoUser.getPassword(), authorities, infoUser);
        }
        return null;
    }

    private String getNameByLoginModel(InfoUser infoUser) {
        switch (infoUser.getLoginModel()) {
            case 1:
                return infoUser.getMobile();
            case 2:
                return infoUser.getEmail();
            default:
                return null;
        }
    }


}
