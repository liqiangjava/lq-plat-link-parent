package com.lq.plat.link.file;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/22
 */
public class InfoFilePara {


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

    public InfoFilePara() {

    }

    public InfoFilePara(String name, String type, Long size, String originalPath) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.originalPath = originalPath;
    }

    public InfoFilePara(String name, String type, Long size, String originalPath, String previewPath) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.originalPath = originalPath;
        this.previewPath = previewPath;
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
