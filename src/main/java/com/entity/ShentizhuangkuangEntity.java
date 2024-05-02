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
 * 身体状况
 *
 * @author 
 * @email
 */
@TableName("shentizhuangkuang")
public class ShentizhuangkuangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShentizhuangkuangEntity() {

	}

	public ShentizhuangkuangEntity(T t) {
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
     * 老人
     */
    @TableField(value = "laoren_id")

    private Integer laorenId;


    /**
     * 疾病状况
     */
    @TableField(value = "jibing_text")

    private String jibingText;


    /**
     * 患病时长
     */
    @TableField(value = "huanbingshichang")

    private String huanbingshichang;


    /**
     * 治疗医院
     */
    @TableField(value = "zhiliaoyiyuan")

    private String zhiliaoyiyuan;


    /**
     * 患病时长
     */
    @TableField(value = "zhiliaoshichang")

    private String zhiliaoshichang;


    /**
     * 复诊周期
     */
    @TableField(value = "fuzhenzhouqi")

    private String fuzhenzhouqi;


    /**
     * 疾病注意事项
     */
    @TableField(value = "jibingzhuyishixiang_text")

    private String jibingzhuyishixiangText;


    /**
     * 用药情况
     */
    @TableField(value = "yongyaoqingkuang_text")

    private String yongyaoqingkuangText;


    /**
     * 用药事项
     */
    @TableField(value = "yongyaoshixiang_text")

    private String yongyaoshixiangText;


    /**
     * 备注
     */
    @TableField(value = "beizhu_content")

    private String beizhuContent;


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
	 * 设置：疾病状况
	 */
    public String getJibingText() {
        return jibingText;
    }


    /**
	 * 获取：疾病状况
	 */

    public void setJibingText(String jibingText) {
        this.jibingText = jibingText;
    }
    /**
	 * 设置：患病时长
	 */
    public String getHuanbingshichang() {
        return huanbingshichang;
    }


    /**
	 * 获取：患病时长
	 */

    public void setHuanbingshichang(String huanbingshichang) {
        this.huanbingshichang = huanbingshichang;
    }
    /**
	 * 设置：治疗医院
	 */
    public String getZhiliaoyiyuan() {
        return zhiliaoyiyuan;
    }


    /**
	 * 获取：治疗医院
	 */

    public void setZhiliaoyiyuan(String zhiliaoyiyuan) {
        this.zhiliaoyiyuan = zhiliaoyiyuan;
    }
    /**
	 * 设置：患病时长
	 */
    public String getZhiliaoshichang() {
        return zhiliaoshichang;
    }


    /**
	 * 获取：患病时长
	 */

    public void setZhiliaoshichang(String zhiliaoshichang) {
        this.zhiliaoshichang = zhiliaoshichang;
    }
    /**
	 * 设置：复诊周期
	 */
    public String getFuzhenzhouqi() {
        return fuzhenzhouqi;
    }


    /**
	 * 获取：复诊周期
	 */

    public void setFuzhenzhouqi(String fuzhenzhouqi) {
        this.fuzhenzhouqi = fuzhenzhouqi;
    }
    /**
	 * 设置：疾病注意事项
	 */
    public String getJibingzhuyishixiangText() {
        return jibingzhuyishixiangText;
    }


    /**
	 * 获取：疾病注意事项
	 */

    public void setJibingzhuyishixiangText(String jibingzhuyishixiangText) {
        this.jibingzhuyishixiangText = jibingzhuyishixiangText;
    }
    /**
	 * 设置：用药情况
	 */
    public String getYongyaoqingkuangText() {
        return yongyaoqingkuangText;
    }


    /**
	 * 获取：用药情况
	 */

    public void setYongyaoqingkuangText(String yongyaoqingkuangText) {
        this.yongyaoqingkuangText = yongyaoqingkuangText;
    }
    /**
	 * 设置：用药事项
	 */
    public String getYongyaoshixiangText() {
        return yongyaoshixiangText;
    }


    /**
	 * 获取：用药事项
	 */

    public void setYongyaoshixiangText(String yongyaoshixiangText) {
        this.yongyaoshixiangText = yongyaoshixiangText;
    }
    /**
	 * 设置：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
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
        return "Shentizhuangkuang{" +
            "id=" + id +
            ", laorenId=" + laorenId +
            ", jibingText=" + jibingText +
            ", huanbingshichang=" + huanbingshichang +
            ", zhiliaoyiyuan=" + zhiliaoyiyuan +
            ", zhiliaoshichang=" + zhiliaoshichang +
            ", fuzhenzhouqi=" + fuzhenzhouqi +
            ", jibingzhuyishixiangText=" + jibingzhuyishixiangText +
            ", yongyaoqingkuangText=" + yongyaoqingkuangText +
            ", yongyaoshixiangText=" + yongyaoshixiangText +
            ", beizhuContent=" + beizhuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
