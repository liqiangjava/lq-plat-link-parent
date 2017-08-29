package com.lq.plat.link.elasticsearch;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/28
 */
public class Elasticsearch {

    public String index;
    public String type;
    public String field;
    public String data;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
