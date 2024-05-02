
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
 * 老人
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoren")
public class LaorenController {
    private static final Logger logger = LoggerFactory.getLogger(LaorenController.class);

    @Autowired
    private LaorenService laorenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private ShequguanliyuanService shequguanliyuanService;
    @Autowired
    private FuwurenyuanService fuwurenyuanService;


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
        PageUtils page = laorenService.queryPage(params);

        //字典表数据转换
        List<LaorenView> list =(List<LaorenView>)page.getList();
        for(LaorenView c:list){
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
        LaorenEntity laoren = laorenService.selectById(id);
        if(laoren !=null){
            //entity转view
            LaorenView view = new LaorenView();
            BeanUtils.copyProperties( laoren , view );//把实体数据重构到view中

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
    public R save(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoren:{}",this.getClass().getName(),laoren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .eq("username", laoren.getUsername())
            .or()
            .eq("laoren_phone", laoren.getLaorenPhone())
            .or()
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if(laorenEntity==null){
            laoren.setCreateTime(new Date());
            laoren.setPassword("123456");
            laorenService.insert(laoren);
            return R.ok();
        }else {
            return R.error(511,"账户或者老人手机号或者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laoren:{}",this.getClass().getName(),laoren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .notIn("id",laoren.getId())
            .andNew()
            .eq("username", laoren.getUsername())
            .or()
            .eq("laoren_phone", laoren.getLaorenPhone())
            .or()
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if("".equals(laoren.getLaorenPhoto()) || "null".equals(laoren.getLaorenPhoto())){
                laoren.setLaorenPhoto(null);
        }
        if(laorenEntity==null){
            laorenService.updateById(laoren);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者老人手机号或者身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        laorenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<LaorenEntity> laorenList = new ArrayList<>();//上传的东西
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
                            LaorenEntity laorenEntity = new LaorenEntity();
//                            laorenEntity.setUsername(data.get(0));                    //账户 要改的
//                            //laorenEntity.setPassword("123456");//密码
//                            laorenEntity.setLaorenUuidNumber(data.get(0));                    //老人编号 要改的
//                            laorenEntity.setLaorenName(data.get(0));                    //老人姓名 要改的
//                            laorenEntity.setLaorenPhone(data.get(0));                    //老人手机号 要改的
//                            laorenEntity.setLaorenPhoto("");//照片
//                            laorenEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            laorenEntity.setNianling(Integer.valueOf(data.get(0)));   //年龄 要改的
//                            laorenEntity.setLaorenAddress(data.get(0));                    //联系方式 要改的
//                            laorenEntity.setLaorenIdNumber(data.get(0));                    //身份证号 要改的
//                            laorenEntity.setQinshuxingming(data.get(0));                    //亲属姓名 要改的
//                            laorenEntity.setQinshuxingmingPhone(data.get(0));                    //亲属联系方式 要改的
//                            laorenEntity.setYiliaokahao(data.get(0));                    //医疗卡号 要改的
//                            laorenEntity.setCreateTime(date);//时间
                            laorenList.add(laorenEntity);


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
                                //老人编号
                                if(seachFields.containsKey("laorenUuidNumber")){
                                    List<String> laorenUuidNumber = seachFields.get("laorenUuidNumber");
                                    laorenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> laorenUuidNumber = new ArrayList<>();
                                    laorenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("laorenUuidNumber",laorenUuidNumber);
                                }
                                //老人手机号
                                if(seachFields.containsKey("laorenPhone")){
                                    List<String> laorenPhone = seachFields.get("laorenPhone");
                                    laorenPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> laorenPhone = new ArrayList<>();
                                    laorenPhone.add(data.get(0));//要改的
                                    seachFields.put("laorenPhone",laorenPhone);
                                }
                                //身份证号
                                if(seachFields.containsKey("laorenIdNumber")){
                                    List<String> laorenIdNumber = seachFields.get("laorenIdNumber");
                                    laorenIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> laorenIdNumber = new ArrayList<>();
                                    laorenIdNumber.add(data.get(0));//要改的
                                    seachFields.put("laorenIdNumber",laorenIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<LaorenEntity> laorenEntities_username = laorenService.selectList(new EntityWrapper<LaorenEntity>().in("username", seachFields.get("username")));
                        if(laorenEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaorenEntity s:laorenEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //老人编号
                        List<LaorenEntity> laorenEntities_laorenUuidNumber = laorenService.selectList(new EntityWrapper<LaorenEntity>().in("laoren_uuid_number", seachFields.get("laorenUuidNumber")));
                        if(laorenEntities_laorenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaorenEntity s:laorenEntities_laorenUuidNumber){
                                repeatFields.add(s.getLaorenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [老人编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //老人手机号
                        List<LaorenEntity> laorenEntities_laorenPhone = laorenService.selectList(new EntityWrapper<LaorenEntity>().in("laoren_phone", seachFields.get("laorenPhone")));
                        if(laorenEntities_laorenPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaorenEntity s:laorenEntities_laorenPhone){
                                repeatFields.add(s.getLaorenPhone());
                            }
                            return R.error(511,"数据库的该表中的 [老人手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //身份证号
                        List<LaorenEntity> laorenEntities_laorenIdNumber = laorenService.selectList(new EntityWrapper<LaorenEntity>().in("laoren_id_number", seachFields.get("laorenIdNumber")));
                        if(laorenEntities_laorenIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaorenEntity s:laorenEntities_laorenIdNumber){
                                repeatFields.add(s.getLaorenIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        laorenService.insertBatch(laorenList);
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
        LaorenEntity laoren = laorenService.selectOne(new EntityWrapper<LaorenEntity>().eq("username", username));
        if(laoren==null || !laoren.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(laoren.getId(),username, "laoren", "老人");
        R r = R.ok();
        r.put("token", token);
        r.put("role","老人");
        r.put("username",laoren.getLaorenName());
        r.put("tableName","laoren");
        r.put("userId",laoren.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody LaorenEntity laoren){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .eq("username", laoren.getUsername())
            .or()
            .eq("laoren_phone", laoren.getLaorenPhone())
            .or()
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            ;
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if(laorenEntity != null)
            return R.error("账户或者老人手机号或者身份证号已经被使用");
        laoren.setCreateTime(new Date());
        laorenService.insert(laoren);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        LaorenEntity laoren = new LaorenEntity();
        laoren.setPassword("123456");
        laoren.setId(id);
        laorenService.updateById(laoren);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        LaorenEntity laoren = laorenService.selectOne(new EntityWrapper<LaorenEntity>().eq("username", username));
        if(laoren!=null){
            laoren.setPassword("123456");
            boolean b = laorenService.updateById(laoren);
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
    public R getCurrLaoren(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        LaorenEntity laoren = laorenService.selectById(id);
        if(laoren !=null){
            //entity转view
            LaorenView view = new LaorenView();
            BeanUtils.copyProperties( laoren , view );//把实体数据重构到view中

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
