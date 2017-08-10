package com.lq.plat.link.service.impl;

import com.lq.plat.link.repository.HotWordRepository;
import com.lq.plat.link.service.HotWordService;
import com.lq.plat.link.system.SysHotWord;
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
public class HotWordServiceImpl implements HotWordService {


    @Autowired
    private HotWordRepository hotWordRepository;

    @Override
    public List<SysHotWord> findAll() {
        return hotWordRepository.findAll();
    }

    @Override
    public String save(SysHotWord sysHotWord) {
        try {
            sysHotWord.setId( WebUtils.getIdWorker().nextId());
            hotWordRepository.save(sysHotWord);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }
}
