package com.entity.model;

import com.entity.ShequguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 社区管理员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShequguanliyuanModel implements Serializable {
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
     * 社区管理员编号
     */
    private String shequguanliyuanUuidNumber;


    /**
     * 社区管理员姓名
     */
    private String shequguanliyuanName;


    /**
     * 社区管理员手机号
     */
    private String shequguanliyuanPhone;


    /**
     * 社区管理员头像
     */
    private String shequguanliyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 社区管理员电子邮箱
     */
    private String shequguanliyuanEmail;


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
	 * 获取：社区管理员编号
	 */
    public String getShequguanliyuanUuidNumber() {
        return shequguanliyuanUuidNumber;
    }


    /**
	 * 设置：社区管理员编号
	 */
    public void setShequguanliyuanUuidNumber(String shequguanliyuanUuidNumber) {
        this.shequguanliyuanUuidNumber = shequguanliyuanUuidNumber;
    }
    /**
	 * 获取：社区管理员姓名
	 */
    public String getShequguanliyuanName() {
        return shequguanliyuanName;
    }


    /**
	 * 设置：社区管理员姓名
	 */
    public void setShequguanliyuanName(String shequguanliyuanName) {
        this.shequguanliyuanName = shequguanliyuanName;
    }
    /**
	 * 获取：社区管理员手机号
	 */
    public String getShequguanliyuanPhone() {
        return shequguanliyuanPhone;
    }


    /**
	 * 设置：社区管理员手机号
	 */
    public void setShequguanliyuanPhone(String shequguanliyuanPhone) {
        this.shequguanliyuanPhone = shequguanliyuanPhone;
    }
    /**
	 * 获取：社区管理员头像
	 */
    public String getShequguanliyuanPhoto() {
        return shequguanliyuanPhoto;
    }


    /**
	 * 设置：社区管理员头像
	 */
    public void setShequguanliyuanPhoto(String shequguanliyuanPhoto) {
        this.shequguanliyuanPhoto = shequguanliyuanPhoto;
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
	 * 获取：社区管理员电子邮箱
	 */
    public String getShequguanliyuanEmail() {
        return shequguanliyuanEmail;
    }


    /**
	 * 设置：社区管理员电子邮箱
	 */
    public void setShequguanliyuanEmail(String shequguanliyuanEmail) {
        this.shequguanliyuanEmail = shequguanliyuanEmail;
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
