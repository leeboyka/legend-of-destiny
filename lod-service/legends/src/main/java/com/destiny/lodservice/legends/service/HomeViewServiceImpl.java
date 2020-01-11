package com.destiny.lodservice.legends.service;

import com.destiny.lodservice.legends.mapper.HalloMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author leeboyka
 */
@Service
public class HomeViewServiceImpl implements HomeViewService {

    @Resource
    private HalloMapper dao;

    @Override
    public String showHallo(String code) {
        String year = dao.getHallo(code) == null ? "" : dao.getHallo(code);
        if (year.equals(code)) {
            return "hallo word";
        } else {
            return "error code";
        }
    }

}
