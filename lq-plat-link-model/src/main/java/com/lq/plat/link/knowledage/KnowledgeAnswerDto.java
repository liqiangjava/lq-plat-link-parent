package com.lq.plat.link.knowledage;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/12
 */
public class KnowledgeAnswerDto {

    //ID
    private Long id;

    //描述
    private String description;

    //知识类型
    private String typeNames;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(String typeNames) {
        this.typeNames = typeNames;
    }
}
