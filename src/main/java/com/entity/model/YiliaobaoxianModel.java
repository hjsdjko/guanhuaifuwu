package com.entity.model;

import com.entity.YiliaobaoxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医疗保险
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YiliaobaoxianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老人
     */
    private Integer laorenId;


    /**
     * 医疗卡号
     */
    private String yibaokahao;


    /**
     * 账户余额
     */
    private Double yiliaobaoxianNumber;


    /**
     * 可报销地区
     */
    private String diqu;


    /**
     * 主要合作医院
     */
    private String yiyuan;


    /**
     * 备注
     */
    private String beizhuContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }


    /**
	 * 设置：老人
	 */
    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 获取：医疗卡号
	 */
    public String getYibaokahao() {
        return yibaokahao;
    }


    /**
	 * 设置：医疗卡号
	 */
    public void setYibaokahao(String yibaokahao) {
        this.yibaokahao = yibaokahao;
    }
    /**
	 * 获取：账户余额
	 */
    public Double getYiliaobaoxianNumber() {
        return yiliaobaoxianNumber;
    }


    /**
	 * 设置：账户余额
	 */
    public void setYiliaobaoxianNumber(Double yiliaobaoxianNumber) {
        this.yiliaobaoxianNumber = yiliaobaoxianNumber;
    }
    /**
	 * 获取：可报销地区
	 */
    public String getDiqu() {
        return diqu;
    }


    /**
	 * 设置：可报销地区
	 */
    public void setDiqu(String diqu) {
        this.diqu = diqu;
    }
    /**
	 * 获取：主要合作医院
	 */
    public String getYiyuan() {
        return yiyuan;
    }


    /**
	 * 设置：主要合作医院
	 */
    public void setYiyuan(String yiyuan) {
        this.yiyuan = yiyuan;
    }
    /**
	 * 获取：备注
	 */
    public String getBeizhuContent() {
        return beizhuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setBeizhuContent(String beizhuContent) {
        this.beizhuContent = beizhuContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
