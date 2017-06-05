package net.aimeizi.dubbo.context;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 所有放到ThreadLocal中的对象统一在SessionHolder中定义和管理 ，避免内存泄露
 *
 * @author Michael.Wang
 * @date 2017/5/25
 */
@Slf4j
public class ThreadLocalHolder {

    private static final ThreadLocal SESSION_MAP = new ThreadLocal();

    protected ThreadLocalHolder() {
    }

    /**
     * 获取元素
     *
     * @param attribute
     * @return
     */
    public static Object get(String attribute) {
        Map map = (Map) SESSION_MAP.get();
        map = (map == null) ? Collections.emptyMap() : map;
        return map.get(attribute);
    }

    /**
     * 获取元素
     *
     * @param attribute
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T get(String attribute, Class<T> clazz) {
        return (T) get(attribute);
    }

    /**
     * 设置属性
     *
     * @param attribute
     * @param value
     */
    public static void set(String attribute, Object value) {
        Map map = (Map) SESSION_MAP.get();

        if (map == null) {
            map = new HashMap();
            SESSION_MAP.set(map);
        }

        map.put(attribute, value);
    }

    /**
     * 删除元素
     *
     * @param attribute
     */
    public static void remove(String attribute) {
        if (SESSION_MAP != null) {
            Map map = (Map) SESSION_MAP.get();
            map.remove(attribute);
        }
    }

    /**
     * 删除全部元素
     */
    public static void removeAll() {
        try {
            if (SESSION_MAP != null) {
                Map map = (Map) SESSION_MAP.get();
                Set<Map.Entry> entries = map.entrySet();
                for (Map.Entry entry : entries) {
                    map.remove(entry.getKey());
                }
                SESSION_MAP.remove();
                map = null;
            }
        } catch (Exception e) {
            log.error("fail to remove ALL of ThreadLocal", e);
        }
    }
}