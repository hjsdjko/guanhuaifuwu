package com.entity.model;

import com.entity.ShentizhuangkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 身体状况
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShentizhuangkuangModel implements Serializable {
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
     * 疾病状况
     */
    private String jibingText;


    /**
     * 患病时长
     */
    private String huanbingshichang;


    /**
     * 治疗医院
     */
    private String zhiliaoyiyuan;


    /**
     * 患病时长
     */
    private String zhiliaoshichang;


    /**
     * 复诊周期
     */
    private String fuzhenzhouqi;


    /**
     * 疾病注意事项
     */
    private String jibingzhuyishixiangText;


    /**
     * 用药情况
     */
    private String yongyaoqingkuangText;


    /**
     * 用药事项
     */
    private String yongyaoshixiangText;


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
	 * 获取：疾病状况
	 */
    public String getJibingText() {
        return jibingText;
    }


    /**
	 * 设置：疾病状况
	 */
    public void setJibingText(String jibingText) {
        this.jibingText = jibingText;
    }
    /**
	 * 获取：患病时长
	 */
    public String getHuanbingshichang() {
        return huanbingshichang;
    }


    /**
	 * 设置：患病时长
	 */
    public void setHuanbingshichang(String huanbingshichang) {
        this.huanbingshichang = huanbingshichang;
    }
    /**
	 * 获取：治疗医院
	 */
    public String getZhiliaoyiyuan() {
        return zhiliaoyiyuan;
    }


    /**
	 * 设置：治疗医院
	 */
    public void setZhiliaoyiyuan(String zhiliaoyiyuan) {
        this.zhiliaoyiyuan = zhiliaoyiyuan;
    }
    /**
	 * 获取：患病时长
	 */
    public String getZhiliaoshichang() {
        return zhiliaoshichang;
    }


    /**
	 * 设置：患病时长
	 */
    public void setZhiliaoshichang(String zhiliaoshichang) {
        this.zhiliaoshichang = zhiliaoshichang;
    }
    /**
	 * 获取：复诊周期
	 */
    public String getFuzhenzhouqi() {
        return fuzhenzhouqi;
    }


    /**
	 * 设置：复诊周期
	 */
    public void setFuzhenzhouqi(String fuzhenzhouqi) {
        this.fuzhenzhouqi = fuzhenzhouqi;
    }
    /**
	 * 获取：疾病注意事项
	 */
    public String getJibingzhuyishixiangText() {
        return jibingzhuyishixiangText;
    }


    /**
	 * 设置：疾病注意事项
	 */
    public void setJibingzhuyishixiangText(String jibingzhuyishixiangText) {
        this.jibingzhuyishixiangText = jibingzhuyishixiangText;
    }
    /**
	 * 获取：用药情况
	 */
    public String getYongyaoqingkuangText() {
        return yongyaoqingkuangText;
    }


    /**
	 * 设置：用药情况
	 */
    public void setYongyaoqingkuangText(String yongyaoqingkuangText) {
        this.yongyaoqingkuangText = yongyaoqingkuangText;
    }
    /**
	 * 获取：用药事项
	 */
    public String getYongyaoshixiangText() {
        return yongyaoshixiangText;
    }


    /**
	 * 设置：用药事项
	 */
    public void setYongyaoshixiangText(String yongyaoshixiangText) {
        this.yongyaoshixiangText = yongyaoshixiangText;
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
