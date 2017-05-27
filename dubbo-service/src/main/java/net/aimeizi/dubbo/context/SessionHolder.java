package net.aimeizi.dubbo.context;

import java.util.HashMap;
import java.util.Map;

/**
 * SessionHolder,主要用于在Service层存取用户信息
 *
 * @author Michael.Wang
 * @date 2017/5/25
 */
public class SessionHolder {

    private static final ThreadLocal SESSION_MAP = new ThreadLocal();

    public static final String USER_SESSION_INFO = "USER_SESSION_INFO";

    protected SessionHolder() {
    }

    public static Object get(String attribute) {
        Map map = (Map) SESSION_MAP.get();
        return map.get(attribute);
    }


    public static <T> T get(String attribute, Class<T> clazz) {
        return (T) get(attribute);
    }


    /**
     * 获取用户信息
     *
     * @return
     */
    public static <T> void setUserSessionInfo(T userSessionInfo) {
        Map map = (Map) SESSION_MAP.get();
        if (map != null) {
            map.put(USER_SESSION_INFO, userSessionInfo);
        }
    }

    public static void set(String attribute, Object value) {
        Map map = (Map) SESSION_MAP.get();

        if (map == null) {
            map = new HashMap();
            SESSION_MAP.set(map);
        }

        map.put(attribute, value);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static <T> T getUserSessionInfo() {
        Map map = (Map) SESSION_MAP.get();
        return map == null ? null : (T) map.get(USER_SESSION_INFO);
    }
}