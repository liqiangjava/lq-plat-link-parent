package com.lq.plat.link.repository;

import com.lq.plat.link.security.InfoRole;
import com.lq.plat.link.support.PlatFormRepository;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/30
 */
public interface InfoRoleRepository extends PlatFormRepository<InfoRole> {


    InfoRole findByName(String name);

}
