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
 * 服务人员
 *
 * @author 
 * @email
 */
@TableName("fuwurenyuan")
public class FuwurenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuwurenyuanEntity() {

	}

	public FuwurenyuanEntity(T t) {
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
     * 服务人员编号
     */
    @TableField(value = "fuwurenyuan_uuid_number")

    private String fuwurenyuanUuidNumber;


    /**
     * 服务人员姓名
     */
    @TableField(value = "fuwurenyuan_name")

    private String fuwurenyuanName;


    /**
     * 服务人员手机号
     */
    @TableField(value = "fuwurenyuan_phone")

    private String fuwurenyuanPhone;


    /**
     * 服务人员头像
     */
    @TableField(value = "fuwurenyuan_photo")

    private String fuwurenyuanPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 服务人员电子邮箱
     */
    @TableField(value = "fuwurenyuan_email")

    private String fuwurenyuanEmail;


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
	 * 设置：服务人员编号
	 */
    public String getFuwurenyuanUuidNumber() {
        return fuwurenyuanUuidNumber;
    }


    /**
	 * 获取：服务人员编号
	 */

    public void setFuwurenyuanUuidNumber(String fuwurenyuanUuidNumber) {
        this.fuwurenyuanUuidNumber = fuwurenyuanUuidNumber;
    }
    /**
	 * 设置：服务人员姓名
	 */
    public String getFuwurenyuanName() {
        return fuwurenyuanName;
    }


    /**
	 * 获取：服务人员姓名
	 */

    public void setFuwurenyuanName(String fuwurenyuanName) {
        this.fuwurenyuanName = fuwurenyuanName;
    }
    /**
	 * 设置：服务人员手机号
	 */
    public String getFuwurenyuanPhone() {
        return fuwurenyuanPhone;
    }


    /**
	 * 获取：服务人员手机号
	 */

    public void setFuwurenyuanPhone(String fuwurenyuanPhone) {
        this.fuwurenyuanPhone = fuwurenyuanPhone;
    }
    /**
	 * 设置：服务人员头像
	 */
    public String getFuwurenyuanPhoto() {
        return fuwurenyuanPhoto;
    }


    /**
	 * 获取：服务人员头像
	 */

    public void setFuwurenyuanPhoto(String fuwurenyuanPhoto) {
        this.fuwurenyuanPhoto = fuwurenyuanPhoto;
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
	 * 设置：服务人员电子邮箱
	 */
    public String getFuwurenyuanEmail() {
        return fuwurenyuanEmail;
    }


    /**
	 * 获取：服务人员电子邮箱
	 */

    public void setFuwurenyuanEmail(String fuwurenyuanEmail) {
        this.fuwurenyuanEmail = fuwurenyuanEmail;
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
        return "Fuwurenyuan{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", fuwurenyuanUuidNumber=" + fuwurenyuanUuidNumber +
            ", fuwurenyuanName=" + fuwurenyuanName +
            ", fuwurenyuanPhone=" + fuwurenyuanPhone +
            ", fuwurenyuanPhoto=" + fuwurenyuanPhoto +
            ", sexTypes=" + sexTypes +
            ", fuwurenyuanEmail=" + fuwurenyuanEmail +
            ", createTime=" + createTime +
        "}";
    }
}
