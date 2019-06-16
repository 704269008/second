package com.collage.mapper;

import com.collage.pojo.Evaluate;
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
public interface EvaluateMapper {

    Evaluate selectById(int evaluateId);

    void insertEvaluate(Evaluate evaluate);

    void deleteById(int evaluateId);

    void updateById(Evaluate evaluate);

    List<Map<String, Object>> list(@Param("condition") String condition);

}
