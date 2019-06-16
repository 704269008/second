package com.collage.mapper;

import com.collage.pojo.Cook;
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
public interface CookMapper {

    Cook selectById(int cookId);

    List<String> selectName();


    void insertCook(Cook cook);

    void deleteById(int cookId);

    void updateById(Cook cook);

    List<Map<String, Object>> list(@Param("condition") String condition, @Param("type") Integer  type, @Param("status") Integer  status);

}
