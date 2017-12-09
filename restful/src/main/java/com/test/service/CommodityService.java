package com.test.service;

import com.test.dao.CommodityDao;
import com.test.entity.Commodity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityService {
    @Resource
    private CommodityDao cd;
    public Commodity findCommodityBySku(String sku){
        return  cd.findCommodityBySku(sku);

    }
}
