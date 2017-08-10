package com.lq.plat.link.service.impl;

import com.lq.plat.link.knowledge.KnowledgeType;
import com.lq.plat.link.repository.KnowledgeTypeRepository;
import com.lq.plat.link.service.KnowledgeTypeService;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
@Service
public class KnowledgeTypeServiceImpl implements KnowledgeTypeService {

    @Autowired
    private KnowledgeTypeRepository knowledgeTypeRepository;

    @Override
    public List<KnowledgeType> findAll() {
        return knowledgeTypeRepository.findAll();
    }

    @Override
    public String save(KnowledgeType knowledgeType) {
        try {
            knowledgeType.setId(WebUtils.getIdWorker().nextId());
            knowledgeTypeRepository.save(knowledgeType);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }
}
