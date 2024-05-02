
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
 * 关怀服务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guanhuaifuwu")
public class GuanhuaifuwuController {
    private static final Logger logger = LoggerFactory.getLogger(GuanhuaifuwuController.class);

    @Autowired
    private GuanhuaifuwuService guanhuaifuwuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FuwurenyuanService fuwurenyuanService;
    @Autowired
    private LaorenService laorenService;

    @Autowired
    private ShequguanliyuanService shequguanliyuanService;


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
        PageUtils page = guanhuaifuwuService.queryPage(params);

        //字典表数据转换
        List<GuanhuaifuwuView> list =(List<GuanhuaifuwuView>)page.getList();
        for(GuanhuaifuwuView c:list){
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
        GuanhuaifuwuEntity guanhuaifuwu = guanhuaifuwuService.selectById(id);
        if(guanhuaifuwu !=null){
            //entity转view
            GuanhuaifuwuView view = new GuanhuaifuwuView();
            BeanUtils.copyProperties( guanhuaifuwu , view );//把实体数据重构到view中

                //级联表
                FuwurenyuanEntity fuwurenyuan = fuwurenyuanService.selectById(guanhuaifuwu.getFuwurenyuanId());
                if(fuwurenyuan != null){
                    BeanUtils.copyProperties( fuwurenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFuwurenyuanId(fuwurenyuan.getId());
                }
                //级联表
                LaorenEntity laoren = laorenService.selectById(guanhuaifuwu.getLaorenId());
                if(laoren != null){
                    BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaorenId(laoren.getId());
                }
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
    public R save(@RequestBody GuanhuaifuwuEntity guanhuaifuwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guanhuaifuwu:{}",this.getClass().getName(),guanhuaifuwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("服务人员".equals(role))
            guanhuaifuwu.setFuwurenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("老人".equals(role))
            guanhuaifuwu.setLaorenId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<GuanhuaifuwuEntity> queryWrapper = new EntityWrapper<GuanhuaifuwuEntity>()
            .eq("fuwurenyuan_id", guanhuaifuwu.getFuwurenyuanId())
            .eq("laoren_id", guanhuaifuwu.getLaorenId())
            .eq("guanhuaifuwu_uuid_number", guanhuaifuwu.getGuanhuaifuwuUuidNumber())
            .eq("guanhuaifuwu_name", guanhuaifuwu.getGuanhuaifuwuName())
            .eq("guanhuaifuwu_types", guanhuaifuwu.getGuanhuaifuwuTypes())
            .eq("fuwu_time", new SimpleDateFormat("yyyy-MM-dd").format(guanhuaifuwu.getFuwuTime()))
            .eq("wancheng_types", guanhuaifuwu.getWanchengTypes())
            .eq("pingjia_types", guanhuaifuwu.getPingjiaTypes())
            .eq("pingjia_text", guanhuaifuwu.getPingjiaText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanhuaifuwuEntity guanhuaifuwuEntity = guanhuaifuwuService.selectOne(queryWrapper);
        if(guanhuaifuwuEntity==null){
            guanhuaifuwu.setInsertTime(new Date());
            guanhuaifuwu.setCreateTime(new Date());
            guanhuaifuwuService.insert(guanhuaifuwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuanhuaifuwuEntity guanhuaifuwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,guanhuaifuwu:{}",this.getClass().getName(),guanhuaifuwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("服务人员".equals(role))
//            guanhuaifuwu.setFuwurenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("老人".equals(role))
//            guanhuaifuwu.setLaorenId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<GuanhuaifuwuEntity> queryWrapper = new EntityWrapper<GuanhuaifuwuEntity>()
            .notIn("id",guanhuaifuwu.getId())
            .andNew()
            .eq("fuwurenyuan_id", guanhuaifuwu.getFuwurenyuanId())
            .eq("laoren_id", guanhuaifuwu.getLaorenId())
            .eq("guanhuaifuwu_uuid_number", guanhuaifuwu.getGuanhuaifuwuUuidNumber())
            .eq("guanhuaifuwu_name", guanhuaifuwu.getGuanhuaifuwuName())
            .eq("guanhuaifuwu_types", guanhuaifuwu.getGuanhuaifuwuTypes())
            .eq("fuwu_time", new SimpleDateFormat("yyyy-MM-dd").format(guanhuaifuwu.getFuwuTime()))
            .eq("wancheng_types", guanhuaifuwu.getWanchengTypes())
            .eq("pingjia_types", guanhuaifuwu.getPingjiaTypes())
            .eq("pingjia_text", guanhuaifuwu.getPingjiaText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuanhuaifuwuEntity guanhuaifuwuEntity = guanhuaifuwuService.selectOne(queryWrapper);
        if(guanhuaifuwuEntity==null){
            guanhuaifuwuService.updateById(guanhuaifuwu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        guanhuaifuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GuanhuaifuwuEntity> guanhuaifuwuList = new ArrayList<>();//上传的东西
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
                            GuanhuaifuwuEntity guanhuaifuwuEntity = new GuanhuaifuwuEntity();
//                            guanhuaifuwuEntity.setFuwurenyuanId(Integer.valueOf(data.get(0)));   //服务人员 要改的
//                            guanhuaifuwuEntity.setLaorenId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            guanhuaifuwuEntity.setGuanhuaifuwuUuidNumber(data.get(0));                    //服务编号 要改的
//                            guanhuaifuwuEntity.setGuanhuaifuwuName(data.get(0));                    //服务名称 要改的
//                            guanhuaifuwuEntity.setGuanhuaifuwuTypes(Integer.valueOf(data.get(0)));   //服务类型 要改的
//                            guanhuaifuwuEntity.setYujikaishiTime(new Date(data.get(0)));          //预计开始时间 要改的
//                            guanhuaifuwuEntity.setYujijieshuTime(new Date(data.get(0)));          //预计结束时间 要改的
//                            guanhuaifuwuEntity.setFuwuTime(new Date(data.get(0)));          //服务日期 要改的
//                            guanhuaifuwuEntity.setGuanhuaifuwuContent("");//照片
//                            guanhuaifuwuEntity.setWanchengTypes(Integer.valueOf(data.get(0)));   //状态 要改的
//                            guanhuaifuwuEntity.setPingjiaTypes(Integer.valueOf(data.get(0)));   //评价等级 要改的
//                            guanhuaifuwuEntity.setPingjiaText(data.get(0));                    //评价结果 要改的
//                            guanhuaifuwuEntity.setInsertTime(date);//时间
//                            guanhuaifuwuEntity.setCreateTime(date);//时间
                            guanhuaifuwuList.add(guanhuaifuwuEntity);


                            //把要查询是否重复的字段放入map中
                                //服务编号
                                if(seachFields.containsKey("guanhuaifuwuUuidNumber")){
                                    List<String> guanhuaifuwuUuidNumber = seachFields.get("guanhuaifuwuUuidNumber");
                                    guanhuaifuwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guanhuaifuwuUuidNumber = new ArrayList<>();
                                    guanhuaifuwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("guanhuaifuwuUuidNumber",guanhuaifuwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //服务编号
                        List<GuanhuaifuwuEntity> guanhuaifuwuEntities_guanhuaifuwuUuidNumber = guanhuaifuwuService.selectList(new EntityWrapper<GuanhuaifuwuEntity>().in("guanhuaifuwu_uuid_number", seachFields.get("guanhuaifuwuUuidNumber")));
                        if(guanhuaifuwuEntities_guanhuaifuwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuanhuaifuwuEntity s:guanhuaifuwuEntities_guanhuaifuwuUuidNumber){
                                repeatFields.add(s.getGuanhuaifuwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [服务编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guanhuaifuwuService.insertBatch(guanhuaifuwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
