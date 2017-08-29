package com.lq.plat.link.service;

import com.lq.plat.link.security.InfoRole;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/6
 */
public interface InfoRoleService {

    public List<InfoRole> findAll();

    public InfoRole findOne(Long id);

    public InfoRole getInfoRoleByName(String name);

    public String save(InfoRole infoRole);

}
