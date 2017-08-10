package com.lq.plat.link.service;

import com.lq.plat.link.system.SysHotWord;

import java.util.List;

/**
 * 执词服务
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/3
 */
public interface HotWordService {

    public List<SysHotWord> findAll();

    public String save(SysHotWord sysHotWord);

}
