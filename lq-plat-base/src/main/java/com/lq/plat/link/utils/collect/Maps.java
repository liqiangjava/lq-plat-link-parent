package com.lq.plat.link.utils.collect;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class Maps {

    public static <K, V> WeakHashMap<K, V> newWeakHashMap()
    {
        return new WeakHashMap();
    }

    public static <K, V> WeakHashMap<K, V> newWeakHashMap(int initialCapacity)
    {
        return new WeakHashMap(initialCapacity);
    }

    public static <K, V> HashMap<K, V> newHashMap()
    {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> newHashMap(int initialCapacity)
    {
        return new HashMap(initialCapacity);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap()
    {
        return new LinkedHashMap(1);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(int initialCapacity)
    {
        return new LinkedHashMap(initialCapacity);
    }

    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap()
    {
        return new ConcurrentHashMap();
    }

    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap(int initialCapacity)
    {
        return new ConcurrentHashMap(initialCapacity);
    }

    public static String getKey(Map<String, Object> map, String value)
    {
        for (Map.Entry<String, Object> ent : map.entrySet()) {
            if (ent.getValue().equals(value)) {
                return (String)ent.getKey();
            }
        }
        return "";
    }
}
