package com.lq.plat.link;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/30
 */
//@Component
public class PlatFormSecurity {

    public boolean check(Authentication authentication, HttpServletRequest request) {
        System.out.print(request.getRequestURI());

        Object principal = authentication.getPrincipal();
        if (principal != null && principal instanceof UserDetails){
            System.out.print(((UserDetails) principal).getAuthorities());
        }

        return true;
    }

}
