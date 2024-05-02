package com.dao;

import com.entity.GuanhuaifuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GuanhuaifuwuView;

/**
 * 关怀服务 Dao 接口
 *
 * @author 
 */
public interface GuanhuaifuwuDao extends BaseMapper<GuanhuaifuwuEntity> {

   List<GuanhuaifuwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
