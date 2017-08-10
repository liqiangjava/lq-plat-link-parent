package com.lq.plat.link.service.impl;

import com.lq.plat.link.account.InfoAccount;
import com.lq.plat.link.account.InfoAccountPara;
import com.lq.plat.link.repository.InfoAccountRepository;
import com.lq.plat.link.service.InfoAccountService;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.DTOUtils;
import com.lq.plat.link.utils.security.UserSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/9
 */
@Service
public class InfoAccountServiceImpl implements InfoAccountService {

    @Autowired
    private InfoAccountRepository infoAccountRepository;

    @Override
    public String update(InfoAccountPara infoAccountPara) {

        Long userId = UserSecurityUtils.getInfoUserId();
        InfoAccount infoAccount = infoAccountRepository.findByUserId(userId);

        if (infoAccount == null) {
            return ConstantParaUtil.NOT_EXISTS_INFO_ACCOUNT;
        }
        try {
            infoAccountRepository.save( DTOUtils.map(infoAccountPara, InfoAccount.class));
            return ConstantParaUtil.SUCCESS_UPDATE_CH;
        } catch (Exception e) {
            return ConstantParaUtil.FALSE_UPDATE_CH;
        }
    }
}
