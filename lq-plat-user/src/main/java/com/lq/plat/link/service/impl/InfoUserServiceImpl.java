package com.lq.plat.link.service.impl;

import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.account.InfoAccount;
import com.lq.plat.link.repository.InfoRoleRepository;
import com.lq.plat.link.repository.InfoUserRepository;
import com.lq.plat.link.repository.InfoUserRoleRepository;
import com.lq.plat.link.security.InfoRole;
import com.lq.plat.link.security.InfoUserRole;
import com.lq.plat.link.service.InfoUserService;
import com.lq.plat.link.user.InfoUser;
import com.lq.plat.link.user.InfoUserDto;
import com.lq.plat.link.user.InfoUserPara;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.DTOUtils;
import com.lq.plat.link.utils.WebUtils;
import com.lq.plat.link.utils.security.UserSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
@Service
public class InfoUserServiceImpl implements InfoUserService {


    @Autowired
    private InfoUserRepository infoUserRepository;

    @Autowired
    private InfoRoleRepository infoRoleRepository;

    @Autowired
    private InfoUserRoleRepository infoUserRoleRepository;

    @Override
    public InfoUser getInfoUserByUsername(String username) {
        return infoUserRepository.findByMobileOrEmail(username,ConstantParaUtil.USE);
    }

    @Override
    public InfoUserDto findOne() {
        InfoUserDto infoUserDto = DTOUtils.map(UserSecurityUtils.getInfoUser(), InfoUserDto.class);
        return infoUserDto;
    }

    @Override
    public String save(InfoUser infoUser) {
        try {
            infoUser.setId(WebUtils.getIdWorker().nextId());
            infoUserRepository.save(infoUser);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }


    @Override
    public ResponseEntity<PlatformResult> save(String username, String password, Integer loginModel) {
        try {
            String newPassword = new BCryptPasswordEncoder().encode(password);
                  //  BCrypt.hashpw(password, "liqiang");
            //判断用户名称是否存在
            InfoUser infoUser =
                    infoUserRepository.findByMobileOrEmail(username,ConstantParaUtil.USE);
            if (!StringUtils.isEmpty(infoUser)) {
                return ApiUtils.error(ConstantParaUtil.USERNAME_DATA_EXISTS);
            }
            infoUser = new InfoUser();
            infoUser.setId(WebUtils.getIdWorker().nextId());
            if (loginModel == 1) {//手机方式
                infoUser.setMobile(username);
            } else if (loginModel == 2) {//邮箱方式
                infoUser.setEmail(username);
            }
            infoUser.setLoginModel(loginModel);
            infoUser.setPassword(newPassword);
            InfoAccount infoAccount = new InfoAccount();
            infoAccount.setId(WebUtils.getIdWorker().nextId());
            infoAccount.setInfoUser(infoUser);
            infoUser.setInfoAccount(infoAccount);

            InfoRole infoRole = infoRoleRepository.findByName(ConstantParaUtil.ADMIN);
            if(infoRole == null){
                return ApiUtils.error(ConstantParaUtil.NOT_FIND_INFO_USER_ROLE);
            }
            InfoUserRole infoUserRole = new InfoUserRole();
            infoUserRole.setId(WebUtils.getIdWorker().nextId());
            infoUserRole.setInfoUser(infoUser);
            infoUserRole.setInfoRole(infoRole);



            infoUserRoleRepository.save(infoUserRole);
            return ApiUtils.ok(ConstantParaUtil.SUCCESS_CH);
        } catch (Exception e) {
            e.printStackTrace();
             return ApiUtils.error(ConstantParaUtil.FALSE_CH);
        }

    }

    @Override
    public String update(InfoUserPara infoUserPara) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            InfoUser infoUser = infoUserRepository.findByMobileOrEmail(username,ConstantParaUtil.USE);
            //如果当前新,旧密码同时为空时的操作
            if (StringUtils.isEmpty(infoUserPara.getOldPassword()) && StringUtils.isEmpty(infoUserPara.getPassword())) {
                InfoUser ninfoUser = conversionInfoUser(infoUserPara, infoUser);
                infoUserRepository.save(ninfoUser);
            } else if (!StringUtils.isEmpty(infoUserPara.getOldPassword()) && !StringUtils.isEmpty(infoUserPara.getPassword())) {
                //当前新,旧密码都不为空时,判断旧密码与原密码是否一致
                String oPassword = new BCryptPasswordEncoder().encode(infoUserPara.getOldPassword());
                InfoUser ninfoUser = conversionInfoUser(infoUserPara, infoUser);
                if (!oPassword.equals(infoUser.getPassword())) {
                    return ConstantParaUtil.FALSE_ORIGINAL_PASSWORD;
                }
                ninfoUser.setPassword(new BCryptPasswordEncoder().encode(infoUserPara.getPassword()));
            }
            return ConstantParaUtil.SUCCESS_UPDATE_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_UPDATE_CH;
        }
    }

    /**
     * 转化参数
     *
     * @param infoUserPara
     * @param infoUser
     * @return
     */
    private InfoUser conversionInfoUser(InfoUserPara infoUserPara, InfoUser infoUser) {
        InfoUser nInfoUser = infoUser;

        if (!StringUtils.isEmpty(infoUserPara.getUsername())) {
            nInfoUser.setUsername(infoUserPara.getUsername());
        }

        if (!StringUtils.isEmpty(infoUserPara.getDescription())) {
            nInfoUser.setDescription(infoUserPara.getDescription());
        }
        if (!StringUtils.isEmpty(infoUserPara.getSex())) {
            nInfoUser.setSex(infoUserPara.getSex());
        }
        if (!StringUtils.isEmpty(infoUserPara.getPortrait())) {
            nInfoUser.setPortrait(infoUserPara.getPortrait());
        }
        if (!StringUtils.isEmpty(infoUserPara.getPosition())) {
            nInfoUser.setPosition(infoUserPara.getPosition());
        }

        return nInfoUser;
    }

    @Override
    public void remove() {
        //用户状态:0:使用 1:删除 2.审核
        Long id = UserSecurityUtils.getInfoUserId();
        infoUserRepository.updateStatusById(ConstantParaUtil.DELETE, id);
    }
}
