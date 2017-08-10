package com.lq.plat.link.service;

import com.lq.plat.link.system.SysFeedback;

import java.util.List;

/**
 * 反馈服务
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/3
 */
public interface FeedbackService {

    public List<SysFeedback> findAll();

    public String save(SysFeedback sysFeedback);

}
