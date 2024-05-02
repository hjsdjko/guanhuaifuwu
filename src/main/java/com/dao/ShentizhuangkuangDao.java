package com.dao;

import com.entity.ShentizhuangkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShentizhuangkuangView;

/**
 * 身体状况 Dao 接口
 *
 * @author 
 */
public interface ShentizhuangkuangDao extends BaseMapper<ShentizhuangkuangEntity> {

   List<ShentizhuangkuangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
