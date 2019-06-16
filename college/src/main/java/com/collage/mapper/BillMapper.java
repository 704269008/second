package com.collage.mapper;

import com.collage.pojo.Bill;
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
public interface BillMapper  {
    Bill selectById(int billId);
    List<Bill> selectBill(int orderid);
    List<Map<String, Object>> selectByOrderId(int orderid);
    List<Map<String, Object>> selByOrderId(int orderid);
    void updateById(Bill bill);
    void insert(Bill bill);

    /**
     * 根据条件查询用户列表
     *
     * @return
     */
    List<Map<String, Object>> list(@Param("name") String name,@Param("paystatus") Integer paystatus,@Param("mealstatus") Integer mealstatus, @Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<Map<String, Object>> getOrderIdList(@Param("name") String name,@Param("paystatus") Integer paystatus);


    List<Map<String, Object>> selectDayProfit(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectMonthProfit(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectYearProfit(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<Map<String, Object>> selectDayCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectMonthCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectYearCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendDayCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyDayCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendMonthCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyMonthCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendYearCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyYearCook(@Param("beginTime") String beginTime, @Param("endTime") String endTime);


    List<Map<String, Object>> selectDayWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectMonthWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectYearWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendDayWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyDayWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendMonthWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyMonthWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendYearWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyYearWaiter(@Param("beginTime") String beginTime, @Param("endTime") String endTime);


    List<Map<String, Object>> selectDayMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectMonthMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> selectYearMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendDayMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyDayMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendMonthMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyMonthMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> legendYearMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> keyYearMenus(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

}
