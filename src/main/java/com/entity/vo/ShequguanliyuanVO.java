package com.entity.vo;

import com.entity.ShequguanliyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 社区管理员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shequguanliyuan")
public class ShequguanliyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 社区管理员编号
     */

    @TableField(value = "shequguanliyuan_uuid_number")
    private String shequguanliyuanUuidNumber;


    /**
     * 社区管理员姓名
     */

    @TableField(value = "shequguanliyuan_name")
    private String shequguanliyuanName;


    /**
     * 社区管理员手机号
     */

    @TableField(value = "shequguanliyuan_phone")
    private String shequguanliyuanPhone;


    /**
     * 社区管理员头像
     */

    @TableField(value = "shequguanliyuan_photo")
    private String shequguanliyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 社区管理员电子邮箱
     */

    @TableField(value = "shequguanliyuan_email")
    private String shequguanliyuanEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：社区管理员编号
	 */
    public String getShequguanliyuanUuidNumber() {
        return shequguanliyuanUuidNumber;
    }


    /**
	 * 获取：社区管理员编号
	 */

    public void setShequguanliyuanUuidNumber(String shequguanliyuanUuidNumber) {
        this.shequguanliyuanUuidNumber = shequguanliyuanUuidNumber;
    }
    /**
	 * 设置：社区管理员姓名
	 */
    public String getShequguanliyuanName() {
        return shequguanliyuanName;
    }


    /**
	 * 获取：社区管理员姓名
	 */

    public void setShequguanliyuanName(String shequguanliyuanName) {
        this.shequguanliyuanName = shequguanliyuanName;
    }
    /**
	 * 设置：社区管理员手机号
	 */
    public String getShequguanliyuanPhone() {
        return shequguanliyuanPhone;
    }


    /**
	 * 获取：社区管理员手机号
	 */

    public void setShequguanliyuanPhone(String shequguanliyuanPhone) {
        this.shequguanliyuanPhone = shequguanliyuanPhone;
    }
    /**
	 * 设置：社区管理员头像
	 */
    public String getShequguanliyuanPhoto() {
        return shequguanliyuanPhoto;
    }


    /**
	 * 获取：社区管理员头像
	 */

    public void setShequguanliyuanPhoto(String shequguanliyuanPhoto) {
        this.shequguanliyuanPhoto = shequguanliyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：社区管理员电子邮箱
	 */
    public String getShequguanliyuanEmail() {
        return shequguanliyuanEmail;
    }


    /**
	 * 获取：社区管理员电子邮箱
	 */

    public void setShequguanliyuanEmail(String shequguanliyuanEmail) {
        this.shequguanliyuanEmail = shequguanliyuanEmail;
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
