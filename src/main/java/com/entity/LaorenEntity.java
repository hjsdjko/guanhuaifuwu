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
 * 老人
 *
 * @author 
 * @email
 */
@TableName("laoren")
public class LaorenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaorenEntity() {

	}

	public LaorenEntity(T t) {
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
     * 老人编号
     */
    @TableField(value = "laoren_uuid_number")

    private String laorenUuidNumber;


    /**
     * 老人姓名
     */
    @TableField(value = "laoren_name")

    private String laorenName;


    /**
     * 老人手机号
     */
    @TableField(value = "laoren_phone")

    private String laorenPhone;


    /**
     * 老人照片
     */
    @TableField(value = "laoren_photo")

    private String laorenPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 年龄
     */
    @TableField(value = "nianling")

    private Integer nianling;


    /**
     * 联系方式
     */
    @TableField(value = "laoren_address")

    private String laorenAddress;


    /**
     * 身份证号
     */
    @TableField(value = "laoren_id_number")

    private String laorenIdNumber;


    /**
     * 亲属姓名
     */
    @TableField(value = "qinshuxingming")

    private String qinshuxingming;


    /**
     * 亲属联系方式
     */
    @TableField(value = "qinshuxingming_phone")

    private String qinshuxingmingPhone;


    /**
     * 医疗卡号
     */
    @TableField(value = "yiliaokahao")

    private String yiliaokahao;


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
	 * 设置：老人编号
	 */
    public String getLaorenUuidNumber() {
        return laorenUuidNumber;
    }


    /**
	 * 获取：老人编号
	 */

    public void setLaorenUuidNumber(String laorenUuidNumber) {
        this.laorenUuidNumber = laorenUuidNumber;
    }
    /**
	 * 设置：老人姓名
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 获取：老人姓名
	 */

    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
    }
    /**
	 * 设置：老人手机号
	 */
    public String getLaorenPhone() {
        return laorenPhone;
    }


    /**
	 * 获取：老人手机号
	 */

    public void setLaorenPhone(String laorenPhone) {
        this.laorenPhone = laorenPhone;
    }
    /**
	 * 设置：老人照片
	 */
    public String getLaorenPhoto() {
        return laorenPhoto;
    }


    /**
	 * 获取：老人照片
	 */

    public void setLaorenPhoto(String laorenPhoto) {
        this.laorenPhoto = laorenPhoto;
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
	 * 设置：年龄
	 */
    public Integer getNianling() {
        return nianling;
    }


    /**
	 * 获取：年龄
	 */

    public void setNianling(Integer nianling) {
        this.nianling = nianling;
    }
    /**
	 * 设置：联系方式
	 */
    public String getLaorenAddress() {
        return laorenAddress;
    }


    /**
	 * 获取：联系方式
	 */

    public void setLaorenAddress(String laorenAddress) {
        this.laorenAddress = laorenAddress;
    }
    /**
	 * 设置：身份证号
	 */
    public String getLaorenIdNumber() {
        return laorenIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setLaorenIdNumber(String laorenIdNumber) {
        this.laorenIdNumber = laorenIdNumber;
    }
    /**
	 * 设置：亲属姓名
	 */
    public String getQinshuxingming() {
        return qinshuxingming;
    }


    /**
	 * 获取：亲属姓名
	 */

    public void setQinshuxingming(String qinshuxingming) {
        this.qinshuxingming = qinshuxingming;
    }
    /**
	 * 设置：亲属联系方式
	 */
    public String getQinshuxingmingPhone() {
        return qinshuxingmingPhone;
    }


    /**
	 * 获取：亲属联系方式
	 */

    public void setQinshuxingmingPhone(String qinshuxingmingPhone) {
        this.qinshuxingmingPhone = qinshuxingmingPhone;
    }
    /**
	 * 设置：医疗卡号
	 */
    public String getYiliaokahao() {
        return yiliaokahao;
    }


    /**
	 * 获取：医疗卡号
	 */

    public void setYiliaokahao(String yiliaokahao) {
        this.yiliaokahao = yiliaokahao;
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
        return "Laoren{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", laorenUuidNumber=" + laorenUuidNumber +
            ", laorenName=" + laorenName +
            ", laorenPhone=" + laorenPhone +
            ", laorenPhoto=" + laorenPhoto +
            ", sexTypes=" + sexTypes +
            ", nianling=" + nianling +
            ", laorenAddress=" + laorenAddress +
            ", laorenIdNumber=" + laorenIdNumber +
            ", qinshuxingming=" + qinshuxingming +
            ", qinshuxingmingPhone=" + qinshuxingmingPhone +
            ", yiliaokahao=" + yiliaokahao +
            ", createTime=" + createTime +
        "}";
    }
}
