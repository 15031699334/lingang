package com.boot.gang.service.Impl;

import com.boot.gang.entity.Config;
import com.boot.gang.mapper.ConfigMapper;
import com.boot.gang.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-01-18 03:09
 **/
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigMapper configMapper;
    @Override
    public int upVolumePriceList(Config config) {
        return configMapper.updateByPrimaryKey(config);
    }

    @Override
    public Config selectByPrimaryKey(String id) {
        return configMapper.selectByPrimaryKey(id);
    }
}
