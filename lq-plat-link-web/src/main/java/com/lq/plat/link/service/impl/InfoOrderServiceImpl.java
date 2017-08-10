package com.lq.plat.link.service.impl;

import com.lq.plat.link.knowledage.OrderStatusEnum;
import com.lq.plat.link.order.InfoOrder;
import com.lq.plat.link.order.InfoOrderDetail;
import com.lq.plat.link.repository.InfoOrderRepository;
import com.lq.plat.link.service.InfoOrderService;
import com.lq.plat.link.utils.ConstantParaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/10
 */
@Service
public class InfoOrderServiceImpl implements InfoOrderService {

    @Autowired
    private InfoOrderRepository infoOrderRepository;

    @Transactional
    @Override
    public String bestAnswersPayee(Long id) {

        InfoOrder infoOrder =infoOrderRepository.findOne(id);
        if(infoOrder == null){
            return ConstantParaUtil.NOT_EXISTS_INFO_ORDER;
        }
        //创建订单明细
        InfoOrderDetail infoOrderDetail = new InfoOrderDetail();



        infoOrder.setStatus(OrderStatusEnum.ORDER_OVER.getValue());

        return null;
    }
}
