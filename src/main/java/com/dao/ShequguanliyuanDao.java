package com.dao;

import com.entity.ShequguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShequguanliyuanView;

/**
 * 社区管理员 Dao 接口
 *
 * @author 
 */
public interface ShequguanliyuanDao extends BaseMapper<ShequguanliyuanEntity> {

   List<ShequguanliyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
