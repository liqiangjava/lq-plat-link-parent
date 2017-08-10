package com.lq.plat.link.knowledge;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/3
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class KnowledgeQuestionCollect extends BaseEntity {

    //ID
    @Id
    private Long id;

    //问题或回答:ID
    private Long questionId;

    //是否收藏:默认是
    private Boolean favorite ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
