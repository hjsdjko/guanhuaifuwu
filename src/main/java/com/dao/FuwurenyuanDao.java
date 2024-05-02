package com.dao;

import com.entity.FuwurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwurenyuanView;

/**
 * 服务人员 Dao 接口
 *
 * @author 
 */
public interface FuwurenyuanDao extends BaseMapper<FuwurenyuanEntity> {

   List<FuwurenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
