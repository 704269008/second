package com.jns.mapper;

import com.jns.entity.Photo;

import java.util.HashMap;
import java.util.List;

public interface PhotoMapper {
    int add(Photo photo);
    int delete(int id);
    int update(Photo photo);
    Photo get(int id);
    List<Photo> photoList();
    //总计
    int total();
    List<Photo> findByPage(HashMap<String, Object> map);
}
