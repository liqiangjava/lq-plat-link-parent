package com.lq.plat.link.service;

import com.lq.plat.link.knowledge.KnowledgeType;

import java.util.List;

/**
 * 知识类型服务
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/3
 */
public interface KnowledgeTypeService {

    public List<KnowledgeType> findAll();

    public String save(KnowledgeType knowledgeType);

}
