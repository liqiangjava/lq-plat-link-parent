package com.lq.plat.link.service.impl;

import com.lq.plat.link.knowledage.FinanceEimbursementDetailDto;
import com.lq.plat.link.knowledage.FinanceEimbursementDto;
import com.lq.plat.link.service.FinanceService;
import com.lq.plat.link.utils.ArithUtil;
import com.lq.plat.link.utils.NumberToCNUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 李强
 * @brief 概要描述
 * @details 详细描述
 * @date 2017年10月20日
 */
@Service
public class FinanceServiceImpl implements FinanceService{


    @Override
    public FinanceEimbursementDto findAll() {
        FinanceEimbursementDetailDto financeEimbursementDetailDto1 = new FinanceEimbursementDetailDto();
        financeEimbursementDetailDto1.setPayItem("打车费");
        financeEimbursementDetailDto1.setPrice(new BigDecimal("50.15"));
        FinanceEimbursementDetailDto financeEimbursementDetailDto2 = new FinanceEimbursementDetailDto();

        financeEimbursementDetailDto2.setPayItem("住宾馆");
        financeEimbursementDetailDto2.setPrice(new BigDecimal("100"));
        FinanceEimbursementDto financeEimbursementDto = new FinanceEimbursementDto();
        BigDecimal TotalPrice =   ArithUtil.add(financeEimbursementDetailDto1.getPrice(),financeEimbursementDetailDto2.getPrice());
       financeEimbursementDto.setTotalPrice(TotalPrice);
       String chTotalPrice =  NumberToCNUtil.number2CNMontrayUnit(TotalPrice);
        financeEimbursementDto.setChTotalPrice(chTotalPrice);
        List<FinanceEimbursementDetailDto> financeEimbursementDetailDtoList = new ArrayList<FinanceEimbursementDetailDto>();
        financeEimbursementDetailDtoList.add(financeEimbursementDetailDto1);
        financeEimbursementDetailDtoList.add(financeEimbursementDetailDto2);
        financeEimbursementDto.setFinanceEimbursementDetailDtos(financeEimbursementDetailDtoList);
        financeEimbursementDto.setOpeningBank("中国交通银行昆山支行");
        financeEimbursementDto.setBankAccount("20000000000001");
        financeEimbursementDto.setPayTime(new Date());
        return financeEimbursementDto;
    }
}
