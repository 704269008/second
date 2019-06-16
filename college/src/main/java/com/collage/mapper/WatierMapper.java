package com.collage.mapper;

import com.collage.pojo.Watier;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 *
 * @author stylefeng123
 * @since 2019-05-03
 */
public interface WatierMapper {
    Watier selectById(int watierId);
    List<String> selectName();

    void insertWatier(Watier watier);

    void deleteById(int watierId);

    void updateById(Watier watier);

    List<Map<String, Object>> list(@Param("condition") String condition, @Param("status") Integer status);

}
