
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 社区管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shequguanliyuan")
public class ShequguanliyuanController {
    private static final Logger logger = LoggerFactory.getLogger(ShequguanliyuanController.class);

    @Autowired
    private ShequguanliyuanService shequguanliyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private FuwurenyuanService fuwurenyuanService;
    @Autowired
    private LaorenService laorenService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("社区管理员".equals(role))
            params.put("shequguanliyuanId",request.getSession().getAttribute("userId"));
        else if("服务人员".equals(role))
            params.put("fuwurenyuanId",request.getSession().getAttribute("userId"));
        else if("老人".equals(role))
            params.put("laorenId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shequguanliyuanService.queryPage(params);

        //字典表数据转换
        List<ShequguanliyuanView> list =(List<ShequguanliyuanView>)page.getList();
        for(ShequguanliyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShequguanliyuanEntity shequguanliyuan = shequguanliyuanService.selectById(id);
        if(shequguanliyuan !=null){
            //entity转view
            ShequguanliyuanView view = new ShequguanliyuanView();
            BeanUtils.copyProperties( shequguanliyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShequguanliyuanEntity shequguanliyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shequguanliyuan:{}",this.getClass().getName(),shequguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShequguanliyuanEntity> queryWrapper = new EntityWrapper<ShequguanliyuanEntity>()
            .eq("username", shequguanliyuan.getUsername())
            .or()
            .eq("shequguanliyuan_phone", shequguanliyuan.getShequguanliyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShequguanliyuanEntity shequguanliyuanEntity = shequguanliyuanService.selectOne(queryWrapper);
        if(shequguanliyuanEntity==null){
            shequguanliyuan.setCreateTime(new Date());
            shequguanliyuan.setPassword("123456");
            shequguanliyuanService.insert(shequguanliyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者社区管理员手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShequguanliyuanEntity shequguanliyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shequguanliyuan:{}",this.getClass().getName(),shequguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ShequguanliyuanEntity> queryWrapper = new EntityWrapper<ShequguanliyuanEntity>()
            .notIn("id",shequguanliyuan.getId())
            .andNew()
            .eq("username", shequguanliyuan.getUsername())
            .or()
            .eq("shequguanliyuan_phone", shequguanliyuan.getShequguanliyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShequguanliyuanEntity shequguanliyuanEntity = shequguanliyuanService.selectOne(queryWrapper);
        if("".equals(shequguanliyuan.getShequguanliyuanPhoto()) || "null".equals(shequguanliyuan.getShequguanliyuanPhoto())){
                shequguanliyuan.setShequguanliyuanPhoto(null);
        }
        if(shequguanliyuanEntity==null){
            shequguanliyuanService.updateById(shequguanliyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者社区管理员手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shequguanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShequguanliyuanEntity> shequguanliyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShequguanliyuanEntity shequguanliyuanEntity = new ShequguanliyuanEntity();
//                            shequguanliyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //shequguanliyuanEntity.setPassword("123456");//密码
//                            shequguanliyuanEntity.setShequguanliyuanUuidNumber(data.get(0));                    //社区管理员编号 要改的
//                            shequguanliyuanEntity.setShequguanliyuanName(data.get(0));                    //社区管理员姓名 要改的
//                            shequguanliyuanEntity.setShequguanliyuanPhone(data.get(0));                    //社区管理员手机号 要改的
//                            shequguanliyuanEntity.setShequguanliyuanPhoto("");//照片
//                            shequguanliyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            shequguanliyuanEntity.setShequguanliyuanEmail(data.get(0));                    //社区管理员电子邮箱 要改的
//                            shequguanliyuanEntity.setCreateTime(date);//时间
                            shequguanliyuanList.add(shequguanliyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //社区管理员编号
                                if(seachFields.containsKey("shequguanliyuanUuidNumber")){
                                    List<String> shequguanliyuanUuidNumber = seachFields.get("shequguanliyuanUuidNumber");
                                    shequguanliyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shequguanliyuanUuidNumber = new ArrayList<>();
                                    shequguanliyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shequguanliyuanUuidNumber",shequguanliyuanUuidNumber);
                                }
                                //社区管理员手机号
                                if(seachFields.containsKey("shequguanliyuanPhone")){
                                    List<String> shequguanliyuanPhone = seachFields.get("shequguanliyuanPhone");
                                    shequguanliyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> shequguanliyuanPhone = new ArrayList<>();
                                    shequguanliyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("shequguanliyuanPhone",shequguanliyuanPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ShequguanliyuanEntity> shequguanliyuanEntities_username = shequguanliyuanService.selectList(new EntityWrapper<ShequguanliyuanEntity>().in("username", seachFields.get("username")));
                        if(shequguanliyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShequguanliyuanEntity s:shequguanliyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //社区管理员编号
                        List<ShequguanliyuanEntity> shequguanliyuanEntities_shequguanliyuanUuidNumber = shequguanliyuanService.selectList(new EntityWrapper<ShequguanliyuanEntity>().in("shequguanliyuan_uuid_number", seachFields.get("shequguanliyuanUuidNumber")));
                        if(shequguanliyuanEntities_shequguanliyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShequguanliyuanEntity s:shequguanliyuanEntities_shequguanliyuanUuidNumber){
                                repeatFields.add(s.getShequguanliyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [社区管理员编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //社区管理员手机号
                        List<ShequguanliyuanEntity> shequguanliyuanEntities_shequguanliyuanPhone = shequguanliyuanService.selectList(new EntityWrapper<ShequguanliyuanEntity>().in("shequguanliyuan_phone", seachFields.get("shequguanliyuanPhone")));
                        if(shequguanliyuanEntities_shequguanliyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShequguanliyuanEntity s:shequguanliyuanEntities_shequguanliyuanPhone){
                                repeatFields.add(s.getShequguanliyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [社区管理员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shequguanliyuanService.insertBatch(shequguanliyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ShequguanliyuanEntity shequguanliyuan = shequguanliyuanService.selectOne(new EntityWrapper<ShequguanliyuanEntity>().eq("username", username));
        if(shequguanliyuan==null || !shequguanliyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(shequguanliyuan.getId(),username, "shequguanliyuan", "社区管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","社区管理员");
        r.put("username",shequguanliyuan.getShequguanliyuanName());
        r.put("tableName","shequguanliyuan");
        r.put("userId",shequguanliyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ShequguanliyuanEntity shequguanliyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ShequguanliyuanEntity> queryWrapper = new EntityWrapper<ShequguanliyuanEntity>()
            .eq("username", shequguanliyuan.getUsername())
            .or()
            .eq("shequguanliyuan_phone", shequguanliyuan.getShequguanliyuanPhone())
            ;
        ShequguanliyuanEntity shequguanliyuanEntity = shequguanliyuanService.selectOne(queryWrapper);
        if(shequguanliyuanEntity != null)
            return R.error("账户或者社区管理员手机号已经被使用");
        shequguanliyuan.setCreateTime(new Date());
        shequguanliyuanService.insert(shequguanliyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ShequguanliyuanEntity shequguanliyuan = new ShequguanliyuanEntity();
        shequguanliyuan.setPassword("123456");
        shequguanliyuan.setId(id);
        shequguanliyuanService.updateById(shequguanliyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ShequguanliyuanEntity shequguanliyuan = shequguanliyuanService.selectOne(new EntityWrapper<ShequguanliyuanEntity>().eq("username", username));
        if(shequguanliyuan!=null){
            shequguanliyuan.setPassword("123456");
            boolean b = shequguanliyuanService.updateById(shequguanliyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrShequguanliyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ShequguanliyuanEntity shequguanliyuan = shequguanliyuanService.selectById(id);
        if(shequguanliyuan !=null){
            //entity转view
            ShequguanliyuanView view = new ShequguanliyuanView();
            BeanUtils.copyProperties( shequguanliyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
