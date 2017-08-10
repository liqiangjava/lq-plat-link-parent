package com.lq.plat.link.knowledage;

/**
 * 最佳回答者
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/26
 */
public class BestResponderDto {


    private PayeeDto payeeDto;

    private payerDto payerDto;


    public PayeeDto getPayeeDto() {
        return payeeDto;
    }

    public void setPayeeDto(PayeeDto payeeDto) {
        this.payeeDto = payeeDto;
    }

    public com.lq.plat.link.knowledage.payerDto getPayerDto() {
        return payerDto;
    }

    public void setPayerDto(com.lq.plat.link.knowledage.payerDto payerDto) {
        this.payerDto = payerDto;
    }
}
