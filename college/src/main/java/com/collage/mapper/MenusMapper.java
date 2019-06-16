package com.collage.mapper;

import com.collage.pojo.Menus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author stylefeng123
 * @since 2019-05-03
 */
public interface MenusMapper {
    Menus selectById(int menusId);

    void insertMenus(Menus menus);

    void deleteById(int menusId);

    void updateById(Menus menus);

    List<Map<String, Object>> list(@Param("condition") String condition, @Param("type") Integer type, @Param("status") Integer status);

}
