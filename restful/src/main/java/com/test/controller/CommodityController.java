package com.test.controller;

import com.test.entity.Commodity;
import com.test.service.CommodityService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("commodity")
public class CommodityController {
    @Resource
    private CommodityService cs;
    @RequestMapping("findCommodityBySku/{sku}")
        public Commodity findCommodityBySku(@PathVariable String sku){
            return cs.findCommodityBySku(sku);
        }
    }


