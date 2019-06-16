package com.collage.mapper;

import com.collage.pojo.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface NoticeMapper {
    List<Map<String, Object>> list(@Param("condition") String condition);

    Notice selectById(int id);

    void  updateById(Notice notice);
    void  deleteById(int id);
    void insertNotice(Notice notice);
}
