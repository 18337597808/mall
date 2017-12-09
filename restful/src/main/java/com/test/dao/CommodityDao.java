package com.test.dao;

import com.test.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface CommodityDao {
    Commodity findCommodityBySku(String sku);
}
