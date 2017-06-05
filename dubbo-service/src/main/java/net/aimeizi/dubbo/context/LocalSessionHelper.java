package net.aimeizi.dubbo.context;

/**
 * LocalSessionHelper,所有放到ThreadLocal中的对象统一在此定义和管理 ，避免内存泄露
 *
 * @author Michael.Wang
 * @date 2017/5/25
 */
public class LocalSessionHelper {


    public static final String USER_SESSION_INFO = "USER_SESSION_INFO";

    protected LocalSessionHelper() {
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static <T> void setUserSessionInfo(T userSessionInfo) {
        ThreadLocalHolder.set(USER_SESSION_INFO, userSessionInfo);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static <T> T getUserSessionInfo() {
        return (T) (ThreadLocalHolder.get(USER_SESSION_INFO));
    }

    /**
     * 删除SessionInfo
     */
    public static void removeUserSessionInfo() {
        ThreadLocalHolder.remove(USER_SESSION_INFO);
    }

    /**
     * 删除全部元素
     */
    public static void removeAll() {
        ThreadLocalHolder.removeAll();
    }
}