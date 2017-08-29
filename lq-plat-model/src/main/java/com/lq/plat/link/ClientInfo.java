package com.lq.plat.link;

import java.util.Date;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class ClientInfo {

    private Object ext;
    private Date time;
    private String visitor;
    private String user;
    private String ip;
    private String ua;
    private String url;
    private String uri;
    private String method;
    private String openid;
    private String unionid;

    public Object getExt()
    {
        return this.ext;
    }

    public void setExt(Object ext)
    {
        this.ext = ext;
    }

    public Date getTime()
    {
        return this.time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public String getUser()
    {
        return this.user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getVisitor()
    {
        return this.visitor;
    }

    public void setVisitor(String visitor)
    {
        this.visitor = visitor;
    }

    public String getIp()
    {
        return this.ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getUa()
    {
        return this.ua;
    }

    public void setUa(String ua)
    {
        this.ua = ua;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUri()
    {
        return this.uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }

    public String getOpenid()
    {
        return this.openid;
    }

    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getUnionid()
    {
        return this.unionid;
    }

    public void setUnionid(String unionid)
    {
        this.unionid = unionid;
    }

    public String getMethod()
    {
        return this.method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }
}
