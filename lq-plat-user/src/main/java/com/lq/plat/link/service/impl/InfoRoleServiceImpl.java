package com.lq.plat.link.service.impl;

import com.lq.plat.link.repository.InfoRoleRepository;
import com.lq.plat.link.security.InfoRole;
import com.lq.plat.link.service.InfoRoleService;
import com.lq.plat.link.utils.ConstantParaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/6
 */
@Service
public class InfoRoleServiceImpl implements InfoRoleService {


    @Autowired
    private InfoRoleRepository infoRoleRepository;

    @Override
    public List<InfoRole> findAll() {
        return infoRoleRepository.findAll();
    }


    @Override
    public InfoRole findOne(Long id) {
        return infoRoleRepository.findOne(id);
    }

    @Override
    public InfoRole getInfoRoleByName(String name) {
        return infoRoleRepository.findByName(name);
    }

    @Override
    public String save(InfoRole infoRole) {
        try {
            infoRoleRepository.save(infoRole);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }


}
