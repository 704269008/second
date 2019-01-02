package com.ptteng.academy.rich.util;

import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    前台动态查询，获取列表
* @Author:         zhh
* @CreateDate:     2018/11/26 15:15
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/26 15:15
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

public class DynamicSqlUtil {

    private static final Log log = LogFactory.getLog(DynamicSqlUtil.class);


    /**前台-- 内容模块--文章-视频  动态查询 */




    /**
     * @Description:    根据openid获取用户id
     * @Author:         zhh
     * @CreateDate:     2018/11/30 18:03
     * @UpdateUser:     zhh
     * @UpdateDate:     2018/11/30 18:03
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    public static Map<String,Object> userDynamicSql(String openid){
        Map<String,Object> params = new HashMap<>();
        params.put("openid","'"+openid+"'");
        params.put("@query","id");
        params.put("@table","user");
        return params;
    }



    /**
    * @Description:    前台文章，动态查询
    * @Author:         zhh
    * @CreateDate:     2018/11/26 15:16
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/26 15:16
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    public static Map<String,Object> articleDynamicSql(){
        Map<String,Object> params = new HashMap<>();

        params.put("@order","update_at desc");
        params.put("@query","id");
        params.put("@table","article");

        return params;
    }


    /**
    * @Description:    用户对文章点赞识别
    * @Author:         zhh
    * @CreateDate:     2018/11/26 16:21
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/26 16:21
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> userArticleUpvoteDynamicSql(Long articleId,Long userId){
        Map<String,Object> params = new HashMap<>();
        params.put("article_id",""+articleId+"");
        params.put("user_id",""+userId+"");
        params.put("@query","id");
        params.put("@table","user_article_upvote");

        return params;
    }


    /**
    * @Description:    用户对文章收藏识别
    * @Author:         zhh
    * @CreateDate:     2018/11/26 16:23
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/26 16:23
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> userArticleCollectDynamicSql(Long articleId,Long userId){
        Map<String,Object> params = new HashMap<>();
        params.put("article_id",""+articleId+"");
        params.put("user_id",""+userId+"");
        params.put("@query","id");
        params.put("@table","user_article_collect");

        return params;
    }

    /**
    * @Description:    用户文章收藏
    * @Author:         zhh
    * @CreateDate:     2018/11/28 15:43
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/28 15:43
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> userArticleDynamicSql(Long userId){
        Map<String,Object> params = new HashMap<>();
        params.put("@order","collection_at desc");
        params.put("user_id",""+userId+"");
        params.put("@query","article_id");
        params.put("@table","user_article_collect");
        return params;
    }


    /**
    * @Description:    获取文章轮廓图
    * @Author:         zhh
    * @CreateDate:     2018/11/26 17:27
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/26 17:27
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getArticleBanner(Integer type){
        Map<String,Object> params = new HashMap<>();
        params.put("type",""+type+"");
        params.put("@query","id");
        params.put("@table","article");
        return params;
    }

    /**
    * @Description:    搜索视频列表，动态查询
    * @Author:         zhh
    * @CreateDate:     2018/11/18 13:18
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/18 13:18
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    public static Map<String,Object> videoDynamicSql(Integer subject,Integer grade){
        Map<String,Object> params = new HashMap<>();

        if(DataUtils.isNotNullOrEmpty(subject)){
            params.put("subject & =",""+subject+"");
        }
        if(DataUtils.isNotNullOrEmpty(grade)){
            params.put("grade & =",""+grade+"");
        }

        params.put("@order","update_at desc");
        params.put("@query","id");
        params.put("@table","video");

        return params;
    }

    /**
    * @Description:    用户视频点赞
    * @Author:         zhh
    * @CreateDate:     2018/11/26 18:16
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/26 18:16
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> userVideoUpvoteDynamicSql(Long videoId,Long userId){
        Map<String,Object> params = new HashMap<>();
        params.put("video_id",""+videoId+"");
        params.put("user_id",""+userId+"");
        params.put("@query","id");
        params.put("@table","user_video_upvote");

        return params;
    }


    /**
     * @Description:    用户对视频收藏识别
     * @Author:         zhh
     * @CreateDate:     2018/11/26 16:23
     * @UpdateUser:     zhh
     * @UpdateDate:     2018/11/26 16:23
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    public static Map<String,Object> userVideoCollectDynamicSql(Long videoId,Long userId){
        Map<String,Object> params = new HashMap<>();
        params.put("video_id",""+videoId+"");
        params.put("user_id",""+userId+"");
        params.put("@query","id");
        params.put("@table","user_video_collect");
        return params;
    }

    /**
    * @Description:    用户视频收藏
    * @Author:         zhh
    * @CreateDate:     2018/11/28 15:46
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/28 15:46
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> userVideoDynamicSql(Long userId){
        Map<String,Object> params = new HashMap<>();
        params.put("@order","collection_at desc");
        params.put("user_id",""+userId+"");
        params.put("@query","video_id");
        params.put("@table","user_video_collect");
        return params;
    }


    /**
     * @Description:    获取视频轮廓图
     * @Author:         zhh
     * @CreateDate:     2018/11/26 17:27
     * @UpdateUser:     zhh
     * @UpdateDate:     2018/11/26 17:27
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    public static Map<String,Object> getVideoBanner(Integer type){
        Map<String,Object> params = new HashMap<>();
        params.put("type",""+type+"");
        params.put("@query","id");
        params.put("@table","video");
        return params;
    }

    /**
    * @Description:    根据用户id获取签到表id
    * @Author:         wyq
    * @Date:     2018/11/28 17:16
    * @UpdateUser:     wyq
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getUserSignByUserId(Long userId){
        Map<String,Object> params = new HashMap();
        if(DataUtils.isNotNullOrEmpty(userId)){
            params.put("user_sign.user_id & = "," " + userId + " ");
        }

        params.put("@query","id");

        params.put("@table","user_sign");

        SQLUtil.convert2Sql(params,0,Integer.MAX_VALUE);

        return params;
    }

    /**
    * @Description:    根据phone获取用户id
    * @Author:         wyq
    * @Date:     2018/11/28 21:34
    * @UpdateUser:     wyq
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getUserIdByPhone(String phone){
        Map<String,Object> params = new HashMap();
        if(DataUtils.isNotNullOrEmpty(phone)){
            params.put("user.phone & = "," " + phone + " ");
        }

        params.put("@query","id");

        params.put("@table","user");

        SQLUtil.convert2Sql(params,0,Integer.MAX_VALUE);

        return params;
    }

    /**
    * @Description:    根据email获取用户id
    * @Author:         wyq
    * @Date:     2018/11/29 16:01
    * @UpdateUser:     wyq
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getUserIdByEmail(String email){
        Map<String,Object> params = new HashMap();
        if(DataUtils.isNotNullOrEmpty(email)){
            params.put("user.email & = ","'" + email + "'");
        }

        params.put("@query","id");

        params.put("@table","user");

        SQLUtil.convert2Sql(params,0,Integer.MAX_VALUE);

        return params;
    }

    /**
    * @Description:    根据recordSign获取签到表id
    * @Author:         wyq
    * @Date:     2018/11/29 22:19
    * @UpdateUser:     wyq
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getIdsByRecordSign(){
        Map<String,Object> params = new HashMap();

        params.put("user_sign.record_sign & = "," 1 ");

        params.put("@query","id");

        params.put("@table","user_sign");

        SQLUtil.convert2Sql(params,0,Integer.MAX_VALUE);

        return params;
    }
}
