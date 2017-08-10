package com.lq.plat.link.knowledge;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * 知识类型实体类
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/26
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class KnowledgeType extends BaseEntity {

    //ID
    @Id
    private Long id;
    //名称
    private String name;
    //描述
    @Column(length = 500)
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "knowledgeType")//即时加载
    @OrderBy("id")// 排序，否则每次取出来Set集合元素的顺序都不一样，为什么用Set集合，官方解释是说它的增删改效率最高
    private List<KnowledgeTypeDetail> knowledgeTypeDetails;

    public KnowledgeType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<KnowledgeTypeDetail> getKnowledgeTypeDetails() {
        return knowledgeTypeDetails;
    }

    public void setKnowledgeTypeDetails(List<KnowledgeTypeDetail> knowledgeTypeDetails) {
        this.knowledgeTypeDetails = knowledgeTypeDetails;
    }
}
