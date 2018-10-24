package com.jns.service.impl;

import com.jns.entity.Photo;
import com.jns.mapper.PhotoMapper;
import com.jns.service.PhotoService;
import com.jns.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoMapper photoMapper;
    @Override
    public int add(Photo photo) {
        return photoMapper.add(photo);
    }

    @Override
    public int delete(int id) {
        return photoMapper.delete(id);
    }

    @Override
    public int update(Photo photo) {
        return photoMapper.update(photo);
    }

    @Override
    public Photo get(int id) {
        return photoMapper.get(id);
    }

    @Override
    public List<Photo> photoList() {
        return photoMapper.photoList();
    }

    @Override
    public int total() {
        return photoMapper.total();
    }

    @Override
    public Page<Photo> showByPage(int currPage) {
        HashMap<String,Object> map=new HashMap<>();
        Page<Photo> photoPage=new Page<>();
        photoPage.setCurrPage(currPage);
        int total=photoMapper.total();;
        photoPage.setTotalCount(total);
        int totalPage;
        if(total % photoPage.getPageSize()==0){
            totalPage=total/photoPage.getPageSize();
        }else{
            totalPage=total/photoPage.getPageSize()+1;
        }
        photoPage.setTotalPage(totalPage);
        map.put("start",(currPage-1)*photoPage.getPageSize());
        map.put("size",photoPage.getPageSize());
        List<Photo> photos=photoMapper.findByPage(map);
        photoPage.setList(photos);
        return photoPage;
    }
}
