package com.dachui.myautoconfiguration.core;

/**
 * 接口类
 */
public interface IMyRedis {

    /**
     * set 方法
     * @param key 键
     * @param value 值
     * @return String
     */
    String set(String key, String value);

    /**
     * get操作
     * @param key key
     * @return 返回value
     */
    String get(String key);
}
