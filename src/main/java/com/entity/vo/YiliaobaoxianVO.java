package com.entity.vo;

import com.entity.YiliaobaoxianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医疗保险
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yiliaobaoxian")
public class YiliaobaoxianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
