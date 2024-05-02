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
 * 医疗保险
 *
 * @author 
 * @email
 */
@TableName("yiliaobaoxian")
public class YiliaobaoxianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YiliaobaoxianEntity() {

	}

	public YiliaobaoxianEntity(T t) {
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
     * 医疗卡号
     */
    @TableField(value = "yibaokahao")

    private String yibaokahao;


    /**
     * 账户余额
     */
    @TableField(value = "yiliaobaoxian_number")

    private Double yiliaobaoxianNumber;


    /**
     * 可报销地区
     */
    @TableField(value = "diqu")

    private String diqu;


    /**
     * 主要合作医院
     */
    @TableField(value = "yiyuan")

    private String yiyuan;


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
	 * 设置：医疗卡号
	 */
    public String getYibaokahao() {
        return yibaokahao;
    }


    /**
	 * 获取：医疗卡号
	 */

    public void setYibaokahao(String yibaokahao) {
        this.yibaokahao = yibaokahao;
    }
    /**
	 * 设置：账户余额
	 */
    public Double getYiliaobaoxianNumber() {
        return yiliaobaoxianNumber;
    }


    /**
	 * 获取：账户余额
	 */

    public void setYiliaobaoxianNumber(Double yiliaobaoxianNumber) {
        this.yiliaobaoxianNumber = yiliaobaoxianNumber;
    }
    /**
	 * 设置：可报销地区
	 */
    public String getDiqu() {
        return diqu;
    }


    /**
	 * 获取：可报销地区
	 */

    public void setDiqu(String diqu) {
        this.diqu = diqu;
    }
    /**
	 * 设置：主要合作医院
	 */
    public String getYiyuan() {
        return yiyuan;
    }


    /**
	 * 获取：主要合作医院
	 */

    public void setYiyuan(String yiyuan) {
        this.yiyuan = yiyuan;
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
        return "Yiliaobaoxian{" +
            "id=" + id +
            ", laorenId=" + laorenId +
            ", yibaokahao=" + yibaokahao +
            ", yiliaobaoxianNumber=" + yiliaobaoxianNumber +
            ", diqu=" + diqu +
            ", yiyuan=" + yiyuan +
            ", beizhuContent=" + beizhuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
