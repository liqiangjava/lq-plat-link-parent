package com.lq.plat.link.service.impl;

import com.lq.plat.link.knowledge.KnowledgeType;
import com.lq.plat.link.knowledge.KnowledgeTypeDetail;
import com.lq.plat.link.repository.KnowledgeTypeDetailRepository;
import com.lq.plat.link.repository.KnowledgeTypeRepository;
import com.lq.plat.link.service.KnowledgeTypeDetailService;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/3
 */
@Service
public class KnowledgeTypeDetailServceImpl implements KnowledgeTypeDetailService {


    @Autowired
    private KnowledgeTypeRepository knowledgeTypeRepository;

    @Autowired
    private KnowledgeTypeDetailRepository knowledgeTypeDetailRepository;


    @Override
    public String save(KnowledgeTypeDetail knowledgeTypeDetail, Long id) {
        try {
            KnowledgeType knowledgeType = knowledgeTypeRepository.findOne(id);
            knowledgeTypeDetail.setKnowledgeType(knowledgeType);
            knowledgeTypeDetail.setId(WebUtils.getIdWorker().nextId());
            knowledgeTypeDetailRepository.save(knowledgeTypeDetail);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }
}
