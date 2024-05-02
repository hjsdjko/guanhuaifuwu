package com.entity.vo;

import com.entity.GuanhuaifuwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 关怀服务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("guanhuaifuwu")
public class GuanhuaifuwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 服务人员
     */

    @TableField(value = "fuwurenyuan_id")
    private Integer fuwurenyuanId;


    /**
     * 老人
     */

    @TableField(value = "laoren_id")
    private Integer laorenId;


    /**
     * 服务编号
     */

    @TableField(value = "guanhuaifuwu_uuid_number")
    private String guanhuaifuwuUuidNumber;


    /**
     * 服务名称
     */

    @TableField(value = "guanhuaifuwu_name")
    private String guanhuaifuwuName;


    /**
     * 服务类型
     */

    @TableField(value = "guanhuaifuwu_types")
    private Integer guanhuaifuwuTypes;


    /**
     * 预计开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yujikaishi_time")
    private Date yujikaishiTime;


    /**
     * 预计结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yujijieshu_time")
    private Date yujijieshuTime;


    /**
     * 服务日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fuwu_time")
    private Date fuwuTime;


    /**
     * 服务详情
     */

    @TableField(value = "guanhuaifuwu_content")
    private String guanhuaifuwuContent;


    /**
     * 状态
     */

    @TableField(value = "wancheng_types")
    private Integer wanchengTypes;


    /**
     * 评价等级
     */

    @TableField(value = "pingjia_types")
    private Integer pingjiaTypes;


    /**
     * 评价结果
     */

    @TableField(value = "pingjia_text")
    private String pingjiaText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：服务人员
	 */
    public Integer getFuwurenyuanId() {
        return fuwurenyuanId;
    }


    /**
	 * 获取：服务人员
	 */

    public void setFuwurenyuanId(Integer fuwurenyuanId) {
        this.fuwurenyuanId = fuwurenyuanId;
    }
    /**
	 * 设置：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }


    /**
	 * 获取：老人
	 */

    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 设置：服务编号
	 */
    public String getGuanhuaifuwuUuidNumber() {
        return guanhuaifuwuUuidNumber;
    }


    /**
	 * 获取：服务编号
	 */

    public void setGuanhuaifuwuUuidNumber(String guanhuaifuwuUuidNumber) {
        this.guanhuaifuwuUuidNumber = guanhuaifuwuUuidNumber;
    }
    /**
	 * 设置：服务名称
	 */
    public String getGuanhuaifuwuName() {
        return guanhuaifuwuName;
    }


    /**
	 * 获取：服务名称
	 */

    public void setGuanhuaifuwuName(String guanhuaifuwuName) {
        this.guanhuaifuwuName = guanhuaifuwuName;
    }
    /**
	 * 设置：服务类型
	 */
    public Integer getGuanhuaifuwuTypes() {
        return guanhuaifuwuTypes;
    }


    /**
	 * 获取：服务类型
	 */

    public void setGuanhuaifuwuTypes(Integer guanhuaifuwuTypes) {
        this.guanhuaifuwuTypes = guanhuaifuwuTypes;
    }
    /**
	 * 设置：预计开始时间
	 */
    public Date getYujikaishiTime() {
        return yujikaishiTime;
    }


    /**
	 * 获取：预计开始时间
	 */

    public void setYujikaishiTime(Date yujikaishiTime) {
        this.yujikaishiTime = yujikaishiTime;
    }
    /**
	 * 设置：预计结束时间
	 */
    public Date getYujijieshuTime() {
        return yujijieshuTime;
    }


    /**
	 * 获取：预计结束时间
	 */

    public void setYujijieshuTime(Date yujijieshuTime) {
        this.yujijieshuTime = yujijieshuTime;
    }
    /**
	 * 设置：服务日期
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 获取：服务日期
	 */

    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 设置：服务详情
	 */
    public String getGuanhuaifuwuContent() {
        return guanhuaifuwuContent;
    }


    /**
	 * 获取：服务详情
	 */

    public void setGuanhuaifuwuContent(String guanhuaifuwuContent) {
        this.guanhuaifuwuContent = guanhuaifuwuContent;
    }
    /**
	 * 设置：状态
	 */
    public Integer getWanchengTypes() {
        return wanchengTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setWanchengTypes(Integer wanchengTypes) {
        this.wanchengTypes = wanchengTypes;
    }
    /**
	 * 设置：评价等级
	 */
    public Integer getPingjiaTypes() {
        return pingjiaTypes;
    }


    /**
	 * 获取：评价等级
	 */

    public void setPingjiaTypes(Integer pingjiaTypes) {
        this.pingjiaTypes = pingjiaTypes;
    }
    /**
	 * 设置：评价结果
	 */
    public String getPingjiaText() {
        return pingjiaText;
    }


    /**
	 * 获取：评价结果
	 */

    public void setPingjiaText(String pingjiaText) {
        this.pingjiaText = pingjiaText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
