package com.lq.plat.link.service;

import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.user.InfoUser;
import com.lq.plat.link.user.InfoUserDto;
import com.lq.plat.link.user.InfoUserPara;
import org.springframework.http.ResponseEntity;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public interface InfoUserService {



    public InfoUser getInfoUserByUsername(String username);

    /**
     * 通过ID查询用户信息
     *
     * @return
     */
    public InfoUserDto findOne();

    /**
     * 保存用户信息
     *
     * @param infoUser
     * @return
     */
    public String save(InfoUser infoUser);

    /**
     * 注册用户信息
     *
     * @param username
     * @param password
     * @return
     */
    public ResponseEntity<PlatformResult> save(String username, String password, Integer loginModel);

    /**
     * 更新用户信息
     *
     * @param infoUserPara
     * @return
     */
    public String update(InfoUserPara infoUserPara);

    /**
     * 删除用户信息
     */
    public void remove();


}
