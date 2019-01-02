package com.ptteng.academy.rich.utils;

import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    用于查询列表的动态sql的map
* @Author:         zhh
* @CreateDate:     2018/11/18 10:27
* @UpdateUser:     zhh
* @UpdateDate:     2018/11/18 10:27
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

public class DynamicSqlUtil {

    private static final Log log = LogFactory.getLog(com.ptteng.academy.rich.utils.DynamicSqlUtil.class);


    /**后台-- 内容模块-用户--文章-视频  动态查询 */





    /**
    * @Description:    搜索用户列表，动态查询
    * @Author:         zhh
    * @CreateDate:     2018/11/18 10:33
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/18 10:33
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> userDynamicSql(Long id,String name,Integer grade,String phone,
                String email,Integer status,Integer minBeans,Integer maxBeans,String area){

        Map<String,Object> params = new HashMap<>();

        if(DataUtils.isNotNullOrEmpty(id)){
            params.put("user.id & =",""+id+"");
        }
        if(DataUtils.isNotNullOrEmpty(name)){
            params.put("user.name & like","'%"+name+"%'");
        }
        if(DataUtils.isNotNullOrEmpty(grade)){
            params.put("user.grade & =",""+grade+"");
        }
        if(DataUtils.isNotNullOrEmpty(phone)){
            params.put("user.phone & like","'%"+phone+"%'");
        }
        if(DataUtils.isNotNullOrEmpty(email)){
            params.put("user.email & like","'%"+email+"%'");
        }
        if(DataUtils.isNotNullOrEmpty(status)){
            params.put("user.status & =",""+status+"");
        }
        if(DataUtils.isNotNullOrEmpty(area)){
            params.put("user.area & =","'"+area+"'");
        }
        if(DataUtils.isNotNullOrEmpty(minBeans) || DataUtils.isNotNullOrEmpty(maxBeans)) {
            params.put("@table","user,user_sign");
            params.put("user.id & =","user_sign.user_id");
            if (DataUtils.isNotNullOrEmpty(minBeans)) {
                params.put("user_sign.beans & >=", "" + minBeans + "");
            }
            if (DataUtils.isNotNullOrEmpty(maxBeans)) {
                params.put("user_sign.beans & <=", "" + maxBeans + "");
            }
        }else{
            params.put("@table","user");
        }
        params.put("@order","user.update_at desc");
        params.put("@query","user.id");

       // SQLUtil.convert2Sql方法源码是对上面的解释。
        String s = SQLUtil.convert2Sql(params, 0,Integer.MAX_VALUE);
        log.info(s);

        return params;

    }

    /**
    * @Description:    搜索文章列表，动态查询
    * @Author:         zhh
    * @CreateDate:     2018/11/18 12:17
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/18 12:17
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    public static Map<String,Object> articleDynamicSql(String title,String writer,Integer minUpvote,Integer maxUpvote,
                                                       Integer type,Integer status,Integer minCollection,Integer maxCollection){
        Map<String,Object> params = new HashMap<>();

        if(DataUtils.isNotNullOrEmpty(title)){
            params.put("article.title & like","'%"+title+"%'");
        }
        if(DataUtils.isNotNullOrEmpty(writer)){
            params.put("article.writer & like","'%"+writer+"%'");
        }
        if(DataUtils.isNotNullOrEmpty(minUpvote)){
            params.put("article.upvote & >=",""+minUpvote+"");
        }
        if(DataUtils.isNotNullOrEmpty(maxUpvote)){
            params.put("article.upvote & <=",""+maxUpvote+"");
        }
        if(DataUtils.isNotNullOrEmpty(type)){
            params.put("article.type & =",""+type+"");
        }
        if(DataUtils.isNotNullOrEmpty(status)){
            params.put("article.status & =",""+status+"");
        }
        if(DataUtils.isNotNullOrEmpty(minCollection)){
            params.put("article.collection & >=",""+minCollection+"");
        }
        if(DataUtils.isNotNullOrEmpty(maxCollection)){
            params.put("article.collection & <=",""+maxCollection+"");
        }

        params.put("@order","article.update_at desc");
        params.put("@query","article.id");
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

    public static Map<String,Object> videoDynamicSql(String title,Integer minUpvote,Integer maxUpvote,
                                                       Integer type,Integer status,Integer minCollection,Integer maxCollection,
                                                     Integer subject,Integer grade,String teacherName){
        Map<String,Object> params = new HashMap<>();


        if(DataUtils.isNotNullOrEmpty(title)){
            params.put("video.title & like","'%"+title+"%'");
        }
        if(DataUtils.isNotNullOrEmpty(minUpvote)){
            params.put("video.upvote & >=",""+minUpvote+"");
        }
        if(DataUtils.isNotNullOrEmpty(maxUpvote)){
            params.put("video.upvote & <=",""+maxUpvote+"");
        }
        if(DataUtils.isNotNullOrEmpty(type)){
            params.put("video.type & =",""+type+"");
        }
        if(DataUtils.isNotNullOrEmpty(status)){
            params.put("video.status & =",""+status+"");
        }
        if(DataUtils.isNotNullOrEmpty(subject)){
            params.put("video.subject & =",""+subject+"");
        }
        if(DataUtils.isNotNullOrEmpty(grade)){
            params.put("video.grade & =",""+grade+"");
        }
        if(DataUtils.isNotNullOrEmpty(minCollection)){
            params.put("video.collection & >=",""+minCollection+"");
        }
        if(DataUtils.isNotNullOrEmpty(maxCollection)){
            params.put("video.collection & <=",""+maxCollection+"");
        }
        if(DataUtils.isNotNullOrEmpty(teacherName)){
            params.put("@table","video,teacher");
            params.put("video.teacher_id & =","teacher.id");
            params.put("teacher.name & like","'%"+teacherName+"%'");
        }else{
            params.put("@table","video");
        }
        params.put("@order","video.update_at desc");
        params.put("@query","video.id");

        return params;
    }






    /**后台-- 管理模块-账户--角色--模块  动态查询 */




    /**
    * @Description:    获取账户列表，动态查询
    * @Author:         zhh
    * @CreateDate:     2018/11/24 22:15
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/24 22:15
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> accountDynamicSql(Long roleId,String accountName){

        Map<String,Object> params = new HashMap<>();

        if(DataUtils.isNotNullOrEmpty(roleId)){
            params.put("role_id & =",""+roleId+"");
        }
        if(DataUtils.isNotNullOrEmpty(accountName)){
            params.put("name & like","'%"+accountName+"%'");
        }

        params.put("@order","update_at desc");
        params.put("@query","id");
        params.put("@table","account");
        return params;
    }



    /**
    * @Description:    通过账户名获取账户id
    * @Author:         zhh
    * @CreateDate:     2018/11/23 18:31
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/23 18:31
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getAccountByName(String name){
        Map<String,Object> params = new HashMap<>();
        params.put("name","'"+name+"'");
        params.put("@query","id");
        params.put("@table","account");
        return params;
    }


    /**
    * @Description:    通过角色名获取角色id
    * @Author:         zhh
    * @CreateDate:     2018/11/23 20:42
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/23 20:42
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String, Object> getRoleIdByName(String accountName) {

        Map<String, Object> params = new HashMap<>();

        log.info("从account表中动态查询");
        params.put("name",  "'"+ accountName +"'");
        params.put("@order", " update_at desc ");
        params.put("@query", "role_id");
        params.put("@table", "account");

        return params;
    }

    /**
    * @Description:    获取角色列表
    * @Author:         zhh
    * @CreateDate:     2018/11/23 18:34
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/23 18:34
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getRoles(){
        Map<String,Object> params = new HashMap<>();
        log.info("role列表按照更新时间排序");
        params.put("@order", " update_at desc ");
        params.put("@query", "id");
        params.put("@table", "role");
        return params;
    }

    /**
    * @Description:   根据角色名获取角色id
    * @Author:         zhh
    * @CreateDate:     2018/11/25 13:49
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/25 13:49
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String, Object> getRoleIdByRoleName(String roleName) {

        Map<String, Object> params = new HashMap<String, Object>();

        log.info("从account表中动态查询");
        params.put("name",  "'"+ roleName +"'");
        params.put("@order", " update_at desc ");
        params.put("@query", "id");
        params.put("@table", "role");

        return params;
    }

    /**
     * @Description:    根据角色ID获取ModuleIds集合
     * @Author:         zhh
     * @CreateDate:     2018/11/23 18:38
     * @UpdateUser:     zhh
     * @UpdateDate:     2018/11/23 18:38
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    public static Map<String,Object> getModuleIdsByRoleId(Long roleId){
        Map<String, Object> params = new HashMap<>();

        log.info("RoleModule表中动态查询");
        params.put("role_id",  ""+ roleId +"");
        params.put("@query", "module_id");
        params.put("@table", "role_module");

        return params;
    }



    /**
    * @Description:    根据模块名获取模块id
    * @Author:         zhh
    * @CreateDate:     2018/11/25 18:46
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/25 18:46
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getModuleIdByModuleName(String moduleName){
        Map<String, Object> params = new HashMap<>();

        log.info("module表中动态查询");
        params.put("name",  "'"+ moduleName +"'");
        params.put("@order", " update_at desc ");
        params.put("@query", "id");
        params.put("@table", "module");

        return params;
    }


    /**
    * @Description:    获取模块列表
    * @Author:         zhh
    * @CreateDate:     2018/11/23 18:35
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/23 18:35
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getModules(){
        Map<String,Object> params = new HashMap<>();
        log.info("module列表按照更新时间排序");
        params.put("@order", " update_at desc ");
        params.put("@query", "id");
        params.put("@table", "module");
        return params;
    }


    /**
    * @Description:    根据角色id获取roleModuleIds
    * @Author:         zhh
    * @CreateDate:     2018/11/25 21:46
    * @UpdateUser:     zhh
    * @UpdateDate:     2018/11/25 21:46
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    public static Map<String,Object> getRoleModuleIdsByRoleId(Long roleId){
        Map<String,Object> params = new HashMap<>();
        log.info("role_module列表按照更新时间排序");
        params.put("role_id",  ""+ roleId +"");
        params.put("@query", "id");
        params.put("@table", "role_module");
        return params;
    }



}
