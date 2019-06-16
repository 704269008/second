package com.collage.mapper;

import com.collage.pojo.Cart;

import java.util.List;
import java.util.Map;

public interface CartMapper {
    void insertSelective(Cart cart);
    List<Map<String, Object>> list();
    void  deleteById(Integer id);
    List<Cart> selCart();
    int selectByIDMax();
}
