package com.lq.plat.link.service.impl;

import com.lq.plat.link.account.InfoAccount;
import com.lq.plat.link.knowledage.OrderStatusEnum;
import com.lq.plat.link.order.InfoOrder;
import com.lq.plat.link.order.InfoOrderDetail;
import com.lq.plat.link.repository.InfoOrderDetailRepository;
import com.lq.plat.link.repository.InfoOrderRepository;
import com.lq.plat.link.service.InfoOrderService;
import com.lq.plat.link.utils.ConstantParaUtil;
import com.lq.plat.link.utils.DTOUtils;
import com.lq.plat.link.utils.WebUtils;
import com.lq.plat.link.utils.security.UserSecurityUtils;
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

    @Autowired
    private InfoOrderDetailRepository infoOrderDetailRepository;

    @Transactional
    @Override
    public String bestAnswersPayee(Long orderid, Long payeeuserid) {
        try {
            InfoOrder infoOrder = infoOrderRepository.findOne(orderid);
            if (infoOrder == null) {
                return ConstantParaUtil.NOT_EXISTS_INFO_ORDER;
            }
            //将订单状态设为已完成
            infoOrder.setStatus(OrderStatusEnum.ORDER_OVER.getValue());

            //创建订单明细
            InfoOrderDetail infoOrderDetail = new InfoOrderDetail();
            infoOrderDetail.setId(WebUtils.getIdWorker().nextId());
            infoOrderDetail.setCapitalPayAmount(infoOrder.getCapitalPayAmount());
           //infoOrderDetail.setInfoOrder(infoOrder);
            //付款者，平台管理员用户 haize
            infoOrderDetail.setPayerUserId(UserSecurityUtils.getInfoUserId());
            //收款人ID，通过AnswerID获取
            infoOrderDetail.setPayeeUserId(payeeuserid);
            infoOrder.setStatus(OrderStatusEnum.ORDER_OVER.getValue());
            infoOrderDetailRepository.save(infoOrderDetail);

            return ConstantParaUtil.SUCCESS_PAY;
        } catch (Exception e) {
            return ConstantParaUtil.FALSE_PAY;
        }
    }
}
