package com.lq.plat.link.im;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Reader;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/14
 */
public class GsonUtil {

    private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String toJson(Object obj, Type type) {
        return gson.toJson(obj, type);
    }

    public static Object fromJson(String str, Type type) {
        return gson.fromJson(str, type);
    }

    public static Object fromJson(Reader reader, Type type) {
        return gson.fromJson(reader, type);
    }
}
