package com.dao;

import com.entity.YiliaobaoxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YiliaobaoxianView;

/**
 * 医疗保险 Dao 接口
 *
 * @author 
 */
public interface YiliaobaoxianDao extends BaseMapper<YiliaobaoxianEntity> {

   List<YiliaobaoxianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
