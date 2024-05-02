package com.entity.model;

import com.entity.LaorenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老人
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaorenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 老人编号
     */
    private String laorenUuidNumber;


    /**
     * 老人姓名
     */
    private String laorenName;


    /**
     * 老人手机号
     */
    private String laorenPhone;


    /**
     * 老人照片
     */
    private String laorenPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 年龄
     */
    private Integer nianling;


    /**
     * 联系方式
     */
    private String laorenAddress;


    /**
     * 身份证号
     */
    private String laorenIdNumber;


    /**
     * 亲属姓名
     */
    private String qinshuxingming;


    /**
     * 亲属联系方式
     */
    private String qinshuxingmingPhone;


    /**
     * 医疗卡号
     */
    private String yiliaokahao;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：老人编号
	 */
    public String getLaorenUuidNumber() {
        return laorenUuidNumber;
    }


    /**
	 * 设置：老人编号
	 */
    public void setLaorenUuidNumber(String laorenUuidNumber) {
        this.laorenUuidNumber = laorenUuidNumber;
    }
    /**
	 * 获取：老人姓名
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 设置：老人姓名
	 */
    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
    }
    /**
	 * 获取：老人手机号
	 */
    public String getLaorenPhone() {
        return laorenPhone;
    }


    /**
	 * 设置：老人手机号
	 */
    public void setLaorenPhone(String laorenPhone) {
        this.laorenPhone = laorenPhone;
    }
    /**
	 * 获取：老人照片
	 */
    public String getLaorenPhoto() {
        return laorenPhoto;
    }


    /**
	 * 设置：老人照片
	 */
    public void setLaorenPhoto(String laorenPhoto) {
        this.laorenPhoto = laorenPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getNianling() {
        return nianling;
    }


    /**
	 * 设置：年龄
	 */
    public void setNianling(Integer nianling) {
        this.nianling = nianling;
    }
    /**
	 * 获取：联系方式
	 */
    public String getLaorenAddress() {
        return laorenAddress;
    }


    /**
	 * 设置：联系方式
	 */
    public void setLaorenAddress(String laorenAddress) {
        this.laorenAddress = laorenAddress;
    }
    /**
	 * 获取：身份证号
	 */
    public String getLaorenIdNumber() {
        return laorenIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setLaorenIdNumber(String laorenIdNumber) {
        this.laorenIdNumber = laorenIdNumber;
    }
    /**
	 * 获取：亲属姓名
	 */
    public String getQinshuxingming() {
        return qinshuxingming;
    }


    /**
	 * 设置：亲属姓名
	 */
    public void setQinshuxingming(String qinshuxingming) {
        this.qinshuxingming = qinshuxingming;
    }
    /**
	 * 获取：亲属联系方式
	 */
    public String getQinshuxingmingPhone() {
        return qinshuxingmingPhone;
    }


    /**
	 * 设置：亲属联系方式
	 */
    public void setQinshuxingmingPhone(String qinshuxingmingPhone) {
        this.qinshuxingmingPhone = qinshuxingmingPhone;
    }
    /**
	 * 获取：医疗卡号
	 */
    public String getYiliaokahao() {
        return yiliaokahao;
    }


    /**
	 * 设置：医疗卡号
	 */
    public void setYiliaokahao(String yiliaokahao) {
        this.yiliaokahao = yiliaokahao;
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
