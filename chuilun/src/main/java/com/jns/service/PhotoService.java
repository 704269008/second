package com.jns.service;

import com.jns.entity.Photo;
import com.jns.utils.Page;

import java.util.List;

public interface PhotoService {
    int add(Photo photo);
    int delete(int id);
    int update(Photo photo);
    Photo get(int id);
    List<Photo> photoList();
    //总计
    int total();
    //展示当前页面的内容
    Page<Photo> showByPage(int currPage);
}
