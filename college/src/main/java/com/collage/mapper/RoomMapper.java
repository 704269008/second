package com.collage.mapper;

import com.collage.pojo.Room;
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
public interface RoomMapper  {
    Room selectById(int roomId);

    List<String> selectName();

    void insertRoom(Room room);

    void deleteById(int roomId);

    void updateById(Room room);

    List<Map<String, Object>> list(@Param("condition") String condition, @Param("status") Integer status);

}
