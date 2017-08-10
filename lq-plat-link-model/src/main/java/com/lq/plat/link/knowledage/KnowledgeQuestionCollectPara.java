package com.lq.plat.link.knowledage;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/3
 */
public class KnowledgeQuestionCollectPara {



    //问题ID
    @ApiModelProperty(value = "问题ID")
    private Long questionId;

    //是否收藏:默认是
    @ApiModelProperty(value = "是否收藏")
    private Boolean favorite = true;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}
