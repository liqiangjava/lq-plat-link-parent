package com.lq.plat.link.service.impl;

import com.lq.plat.link.repository.FeedbackRepository;
import com.lq.plat.link.service.FeedbackService;
import com.lq.plat.link.system.SysFeedback;
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
public class FeedbackServiceImpl implements FeedbackService {


    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<SysFeedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public String save(SysFeedback sysFeedback) {
        try {
            sysFeedback.setId( WebUtils.getIdWorker().nextId());
            feedbackRepository.save(sysFeedback);
            return ConstantParaUtil.SUCCESS_CH;
        } catch (Exception e) {
            e.printStackTrace();
            return ConstantParaUtil.FALSE_CH;
        }
    }
}
