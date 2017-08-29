package com.lq.plat.link.constant;

import com.lq.plat.link.utils.collect.Lists;
import com.lq.plat.link.utils.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class PlatformConstants {

    public static final int API_RESPONSE_SUCCESS_CODE = 200;

    public static final int API_RESPONSE_FALSE_CODE = 406;

    public static final String API_RESPONSE_SUCCESS_MESSAGE = "成功";

    public static final String API_RESPONSE_FALSE_MESSAGE = "失败";


    public static String BASE_URL = "";
    public static String CONTEXT = "";
    public static final int POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    public static long MAX_UPLOAD_FILE_SIZE = 5242880L;
    public static int WEB_DEFAULT_TIMEOUT = 10000;
    public static final String KNOWLEDGE = "knowledge";
    public static final String ANONYMOUS = "knowledge";
    public static final int KNOWLEDGE_LEN = 100;
    public static final String URI_API_PREFIX = "api";
    public static final String URI_PLATFORM_REQUEST_DATA_API_PREFIX = "countly";
    public static final String URI_PLATFORM_API_PREFIX = "platform";
    public static final String URI_ADMIN_API_PREFIX = "admin";
    public static final String URI_API = "api/v1/{client}/{channel}";
    public static final int URI_API_LEN = StringUtils.split("api/v1/{client}/{channel}", "/").length;
    public static final String ENTRY = "entry";
    public static final String FORWARD = "forward";
    public static final String CONNECT_URI_API = "api/connect";
    public static final String WECHAT_URI_API = "api/wechat";
    public static final String MEDIA_URI_API = "media";
    public static final String LOG_API = "log";
    public static String PLATFORM = "";
    public static String PLATFORM_NAME = "崔小妹科技平台接口服务";
    public static int TOKEN_EXPIRES_IN = 300;
    public static int STATE_EXPIRES_IN = 20;
    public static final String WEB_INF = "/WEB-INF/";
    public static final String CLASS_PATH = "/classes/";
    public static final String PAY_BACK = "callback";
    public static final String PAY_NOTIFY = "notify";
    public static final String PAY_FAIL = "fail";
    public static final int CLASS_PATH_LENGTH = "/classes/".length();
    public static final String PAGEABLE_DESC_STR = "分页控制参数?size=1&page=0&sort=name,desc,默认为创建时间倒序";
    public static final String PLATFORMS_DESC_STR = "projects:项目,interact:互动平台,knowledge:知识分台";
    public static final String OPENID_BIND_OPER_FLAG = "bind";
    public static final Map<String, String> MIME_MAP = Maps.newHashMap();
    public static final Map<String, String> BROWSER_CONTAINER_MAP = Maps.newHashMap();
    public static final String BROWSER_CONTAINER_WEIXIN = "wx";
    public static boolean IS_CORS_ENABLE = true;
    public static final List<String> INGOR_LOG_LIST = Lists.newArrayList();

    static
    {
        MIME_MAP.put("jpg", "image/jpeg");
        MIME_MAP.put("jpeg", "image/jpeg");
        MIME_MAP.put("gif", "image/gif");
        MIME_MAP.put("png", "image/png");
        MIME_MAP.put("mp3", "audio/mp3");
        MIME_MAP.put("au", "audio/basic");

        BROWSER_CONTAINER_MAP.put("micromessenger", "wx");
        BROWSER_CONTAINER_MAP.put("qq", "qq");

        INGOR_LOG_LIST.add("/todo/");
    }
}
