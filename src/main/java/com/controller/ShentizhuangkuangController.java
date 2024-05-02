
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
 * 身体状况
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shentizhuangkuang")
public class ShentizhuangkuangController {
    private static final Logger logger = LoggerFactory.getLogger(ShentizhuangkuangController.class);

    @Autowired
    private ShentizhuangkuangService shentizhuangkuangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaorenService laorenService;

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
        PageUtils page = shentizhuangkuangService.queryPage(params);

        //字典表数据转换
        List<ShentizhuangkuangView> list =(List<ShentizhuangkuangView>)page.getList();
        for(ShentizhuangkuangView c:list){
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
        ShentizhuangkuangEntity shentizhuangkuang = shentizhuangkuangService.selectById(id);
        if(shentizhuangkuang !=null){
            //entity转view
            ShentizhuangkuangView view = new ShentizhuangkuangView();
            BeanUtils.copyProperties( shentizhuangkuang , view );//把实体数据重构到view中

                //级联表
                LaorenEntity laoren = laorenService.selectById(shentizhuangkuang.getLaorenId());
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
    public R save(@RequestBody ShentizhuangkuangEntity shentizhuangkuang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shentizhuangkuang:{}",this.getClass().getName(),shentizhuangkuang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老人".equals(role))
            shentizhuangkuang.setLaorenId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShentizhuangkuangEntity> queryWrapper = new EntityWrapper<ShentizhuangkuangEntity>()
            .eq("laoren_id", shentizhuangkuang.getLaorenId())
            .eq("jibing_text", shentizhuangkuang.getJibingText())
            .eq("huanbingshichang", shentizhuangkuang.getHuanbingshichang())
            .eq("zhiliaoyiyuan", shentizhuangkuang.getZhiliaoyiyuan())
            .eq("zhiliaoshichang", shentizhuangkuang.getZhiliaoshichang())
            .eq("fuzhenzhouqi", shentizhuangkuang.getFuzhenzhouqi())
            .eq("jibingzhuyishixiang_text", shentizhuangkuang.getJibingzhuyishixiangText())
            .eq("yongyaoqingkuang_text", shentizhuangkuang.getYongyaoqingkuangText())
            .eq("yongyaoshixiang_text", shentizhuangkuang.getYongyaoshixiangText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShentizhuangkuangEntity shentizhuangkuangEntity = shentizhuangkuangService.selectOne(queryWrapper);
        if(shentizhuangkuangEntity==null){
            shentizhuangkuang.setInsertTime(new Date());
            shentizhuangkuang.setCreateTime(new Date());
            shentizhuangkuangService.insert(shentizhuangkuang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShentizhuangkuangEntity shentizhuangkuang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shentizhuangkuang:{}",this.getClass().getName(),shentizhuangkuang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老人".equals(role))
//            shentizhuangkuang.setLaorenId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShentizhuangkuangEntity> queryWrapper = new EntityWrapper<ShentizhuangkuangEntity>()
            .notIn("id",shentizhuangkuang.getId())
            .andNew()
            .eq("laoren_id", shentizhuangkuang.getLaorenId())
            .eq("jibing_text", shentizhuangkuang.getJibingText())
            .eq("huanbingshichang", shentizhuangkuang.getHuanbingshichang())
            .eq("zhiliaoyiyuan", shentizhuangkuang.getZhiliaoyiyuan())
            .eq("zhiliaoshichang", shentizhuangkuang.getZhiliaoshichang())
            .eq("fuzhenzhouqi", shentizhuangkuang.getFuzhenzhouqi())
            .eq("jibingzhuyishixiang_text", shentizhuangkuang.getJibingzhuyishixiangText())
            .eq("yongyaoqingkuang_text", shentizhuangkuang.getYongyaoqingkuangText())
            .eq("yongyaoshixiang_text", shentizhuangkuang.getYongyaoshixiangText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShentizhuangkuangEntity shentizhuangkuangEntity = shentizhuangkuangService.selectOne(queryWrapper);
        if(shentizhuangkuangEntity==null){
            shentizhuangkuangService.updateById(shentizhuangkuang);//根据id更新
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
        shentizhuangkuangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShentizhuangkuangEntity> shentizhuangkuangList = new ArrayList<>();//上传的东西
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
                            ShentizhuangkuangEntity shentizhuangkuangEntity = new ShentizhuangkuangEntity();
//                            shentizhuangkuangEntity.setLaorenId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            shentizhuangkuangEntity.setJibingText(data.get(0));                    //疾病状况 要改的
//                            shentizhuangkuangEntity.setHuanbingshichang(data.get(0));                    //患病时长 要改的
//                            shentizhuangkuangEntity.setZhiliaoyiyuan(data.get(0));                    //治疗医院 要改的
//                            shentizhuangkuangEntity.setZhiliaoshichang(data.get(0));                    //患病时长 要改的
//                            shentizhuangkuangEntity.setFuzhenzhouqi(data.get(0));                    //复诊周期 要改的
//                            shentizhuangkuangEntity.setJibingzhuyishixiangText(data.get(0));                    //疾病注意事项 要改的
//                            shentizhuangkuangEntity.setYongyaoqingkuangText(data.get(0));                    //用药情况 要改的
//                            shentizhuangkuangEntity.setYongyaoshixiangText(data.get(0));                    //用药事项 要改的
//                            shentizhuangkuangEntity.setBeizhuContent("");//照片
//                            shentizhuangkuangEntity.setInsertTime(date);//时间
//                            shentizhuangkuangEntity.setCreateTime(date);//时间
                            shentizhuangkuangList.add(shentizhuangkuangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shentizhuangkuangService.insertBatch(shentizhuangkuangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
