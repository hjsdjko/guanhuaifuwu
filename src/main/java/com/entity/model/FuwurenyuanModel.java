package com.entity.model;

import com.entity.FuwurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服务人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuwurenyuanModel implements Serializable {
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
     * 服务人员编号
     */
    private String fuwurenyuanUuidNumber;


    /**
     * 服务人员姓名
     */
    private String fuwurenyuanName;


    /**
     * 服务人员手机号
     */
    private String fuwurenyuanPhone;


    /**
     * 服务人员头像
     */
    private String fuwurenyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 服务人员电子邮箱
     */
    private String fuwurenyuanEmail;


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
	 * 获取：服务人员编号
	 */
    public String getFuwurenyuanUuidNumber() {
        return fuwurenyuanUuidNumber;
    }


    /**
	 * 设置：服务人员编号
	 */
    public void setFuwurenyuanUuidNumber(String fuwurenyuanUuidNumber) {
        this.fuwurenyuanUuidNumber = fuwurenyuanUuidNumber;
    }
    /**
	 * 获取：服务人员姓名
	 */
    public String getFuwurenyuanName() {
        return fuwurenyuanName;
    }


    /**
	 * 设置：服务人员姓名
	 */
    public void setFuwurenyuanName(String fuwurenyuanName) {
        this.fuwurenyuanName = fuwurenyuanName;
    }
    /**
	 * 获取：服务人员手机号
	 */
    public String getFuwurenyuanPhone() {
        return fuwurenyuanPhone;
    }


    /**
	 * 设置：服务人员手机号
	 */
    public void setFuwurenyuanPhone(String fuwurenyuanPhone) {
        this.fuwurenyuanPhone = fuwurenyuanPhone;
    }
    /**
	 * 获取：服务人员头像
	 */
    public String getFuwurenyuanPhoto() {
        return fuwurenyuanPhoto;
    }


    /**
	 * 设置：服务人员头像
	 */
    public void setFuwurenyuanPhoto(String fuwurenyuanPhoto) {
        this.fuwurenyuanPhoto = fuwurenyuanPhoto;
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
	 * 获取：服务人员电子邮箱
	 */
    public String getFuwurenyuanEmail() {
        return fuwurenyuanEmail;
    }


    /**
	 * 设置：服务人员电子邮箱
	 */
    public void setFuwurenyuanEmail(String fuwurenyuanEmail) {
        this.fuwurenyuanEmail = fuwurenyuanEmail;
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
