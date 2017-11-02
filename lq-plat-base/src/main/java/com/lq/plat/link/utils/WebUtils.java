package com.lq.plat.link.utils;

import com.lq.plat.link.ClientInfo;
import com.lq.plat.link.constant.PlatformConstants;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class WebUtils {
    public static final String CONTENT_LENGTH = "Content-length";
    public static final String USER_AGENT = "user-agent";
    private static final Pattern NETTYPE_PATTERN = Pattern.compile("NetType/(.+) ");

    public static String getWebBaseUrl() {
        String ctx = PlatformConstants.CONTEXT;
        if ((StringUtils.isNotBlank(ctx)) && (!ctx.startsWith("/"))) {
            ctx = "/".concat(ctx);
        }
        String bu = PlatformConstants.BASE_URL;
        if ((StringUtils.isNotBlank(bu)) && (!bu.startsWith("/"))) {
            bu = "/".concat(bu);
        }
        return bu + ctx + "/";
    }

    public static String getServiceUri(String uri) {
        if (uri.startsWith("api/wechat")) {
            return null;
        }
        if (uri.startsWith("api/connect")) {
            return uri.replaceFirst("api/", "");
        }
        int pre_idx = uri.indexOf("api");
        if (pre_idx != -1) {
            uri = uri.substring(pre_idx, uri.length());
        } else {
            return uri;
        }
        String[] uris = StringUtils.split(uri, "/");

        int idx = uri.indexOf("?");
        if (idx != -1) {
            uri = uri.substring(0, idx);
        }
        idx = uri.indexOf("#");
        if (idx != -1) {
            uri = uri.substring(0, idx);
        }
        return StringUtils.join(ArrayUtils.subarray(uris, PlatformConstants.URI_API_LEN, uri.length()), "/");
    }

    public static String getServiceUriId(String uri) {
        return uri.substring(uri.lastIndexOf("/") + 1, uri.length());
    }

    public static String getParaUrl(String url, String... paras) {
        String para = StringUtils.join(paras, "&");
        if (url.indexOf("?") == -1) {
            url = url.replaceAll("/$", "");
            url = String.format("%s?%s", url, para);
        } else {
            url = String.format("%s&%s", url, para);
        }
        return url;
    }

    public static String getUriChannel(String uri) {
        try {
            String[] uris = StringUtils.split(uri, "/");

            return uris[3];
        } catch (Exception e) {
        }
        return "linkin";
    }

    public static String getResultErrCode(String retString) {
        Pattern pattern = Pattern.compile("\"err.*ode\"\\s*:\\s*(\\-*\\w+)");
        Matcher m = pattern.matcher(retString);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    public static String getResultErrMsg(String retString) {
        Pattern pattern = Pattern.compile("\"err.*msg\"\\s*:\\s*\"([^\"]+)\"");
        Matcher m = pattern.matcher(retString);
        if (m.find()) {
            String str = m.group(1);
            try {
                str = StringUtil.unicode2String(str);
            } catch (Exception localException) {
            }
            return str;
        }
        return null;
    }

    public static boolean isiPhone(HttpServletRequest request) {
        return getUserAgent(request).indexOf("iPhone") != -1;
    }

    public static boolean isWeiXin(String ua) {
        return ua.toLowerCase().indexOf("micromessenger") != -1;
    }

    public static String getBrowserContainer(String ua) {
        Set<Map.Entry<String, String>> set = PlatformConstants.BROWSER_CONTAINER_MAP.entrySet();
        ua = ua.toLowerCase();
        for (Map.Entry<String, String> ent : set) {
            if (ua.indexOf((String) ent.getKey()) != -1) {
                return (String) ent.getValue();
            }
        }
        return null;
    }

    public static boolean isUrl(String str) {
        return str.startsWith("http");
    }

    public static String getValidErrorMsg(Collection<ObjectError> errList) {
        Iterator localIterator = errList.iterator();
        if (localIterator.hasNext()) {
            ObjectError obj = (ObjectError) localIterator.next();
            return obj.getDefaultMessage();
        }
        return "";
    }

    public static String getValidErrorMsg(BindingResult result) {
        return getValidErrorMsg(result.getAllErrors());
    }

    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }

    public static IdWorker getIdWorker() {
        IdWorker idWorker = new IdWorker(0, 0);
        return idWorker;
    }


    /**
     * 获取服务器IP地址
     *
     * @return
     */
    public static String getServerIp() {
        String SERVER_IP = null;
        try {
            InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址
            SERVER_IP = address.getHostAddress();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            SERVER_IP = null;
            e.printStackTrace();
        }

        return SERVER_IP;
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getRemoteAddr();
        }
        if (ip == null) {
            return "";
        }
        int sp = ip.indexOf(",");
        if (sp != -1) {
            return ip.substring(0, sp);
        }
        return ip;
    }

    public static String getNetType(String ua) {
        Matcher matcher = NETTYPE_PATTERN.matcher(ua);
        if (matcher.find()) {
            return matcher.group(0).replaceAll("NetType/", "");
        }
        return null;
    }

    public static ClientInfo getClientInfo(HttpServletRequest request) {
        ClientInfo cf = new ClientInfo();

        cf.setIp(getIp(request));
        cf.setUa(getUserAgent(request));
        cf.setUrl(request.getRequestURL().toString());
        cf.setUri(request.getRequestURI());
        cf.setMethod(request.getMethod());

        return cf;
    }

    public static long getContentLength(HttpServletRequest request) {
        long size;
        try {
            size = Long.parseLong(request.getHeader("Content-length"));
        } catch (NumberFormatException e) {
            size = request.getContentLength();
        }
        return size;
    }

}
