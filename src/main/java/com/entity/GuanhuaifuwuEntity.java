package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 关怀服务
 *
 * @author 
 * @email
 */
@TableName("guanhuaifuwu")
public class GuanhuaifuwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GuanhuaifuwuEntity() {

	}

	public GuanhuaifuwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Guanhuaifuwu{" +
            "id=" + id +
            ", fuwurenyuanId=" + fuwurenyuanId +
            ", laorenId=" + laorenId +
            ", guanhuaifuwuUuidNumber=" + guanhuaifuwuUuidNumber +
            ", guanhuaifuwuName=" + guanhuaifuwuName +
            ", guanhuaifuwuTypes=" + guanhuaifuwuTypes +
            ", yujikaishiTime=" + yujikaishiTime +
            ", yujijieshuTime=" + yujijieshuTime +
            ", fuwuTime=" + fuwuTime +
            ", guanhuaifuwuContent=" + guanhuaifuwuContent +
            ", wanchengTypes=" + wanchengTypes +
            ", pingjiaTypes=" + pingjiaTypes +
            ", pingjiaText=" + pingjiaText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
