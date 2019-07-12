package com.itheima.mapper;

import com.itheima.domain.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select *,o.id oid from tab_orders o tab_user u where o.uid=u.id")
    @Results({
            @Result()
    })
    public List<Order> findAll();
}
