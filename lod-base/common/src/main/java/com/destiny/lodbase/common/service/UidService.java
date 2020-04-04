package com.destiny.lodbase.common.service;

/**
 * 唯一id 生成
 * @author leeboyka
 */
public interface UidService {

    /**
     * 获取uid
     *
     * @return 返回uid
     */
    long getUid();

    /**
     * 解析uid
     * @param uid uid
     * @return JSON字符串
     */
    String parseUid(long uid);
}
