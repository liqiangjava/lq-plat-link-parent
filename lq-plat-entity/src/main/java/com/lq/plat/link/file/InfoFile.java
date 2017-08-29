package com.lq.plat.link.file;

import com.lq.plat.link.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

/**
 * 文件实体类
 *
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/20
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class InfoFile extends BaseEntity {

    //ID
    @Id
    private Long id;

    //文件名称
    private String name;

    //文件类型
    private String type;

    //文件大小
    private Long size;

    //文件路径:原始路径
    private String originalPath;

    //预览路径:主要用于缩略图
    private String previewPath;

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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public String getPreviewPath() {
        return previewPath;
    }

    public void setPreviewPath(String previewPath) {
        this.previewPath = previewPath;
    }
}
