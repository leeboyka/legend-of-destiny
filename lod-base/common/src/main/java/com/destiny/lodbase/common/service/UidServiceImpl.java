package com.destiny.lodbase.common.service;

import com.github.wujun234.uid.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author leeboyka
 */
public class UidServiceImpl implements UidService {

    @Autowired
    private UidGenerator defaultUidGenerator;

    @Override
    public long getUid() {
        return defaultUidGenerator.getUID();
    }

    @Override
    public String parseUid(long uid) {
        return defaultUidGenerator.parseUID(uid);
    }
}
