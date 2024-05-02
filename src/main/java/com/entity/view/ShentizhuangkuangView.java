package com.entity.view;

import com.entity.ShentizhuangkuangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 身体状况
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shentizhuangkuang")
public class ShentizhuangkuangView extends ShentizhuangkuangEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 laoren
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

	public ShentizhuangkuangView() {

	}

	public ShentizhuangkuangView(ShentizhuangkuangEntity shentizhuangkuangEntity) {
		try {
			BeanUtils.copyProperties(this, shentizhuangkuangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set laoren
					/**
					* 获取： 老人编号
					*/
					public String getLaorenUuidNumber() {
						return laorenUuidNumber;
					}
					/**
					* 设置： 老人编号
					*/
					public void setLaorenUuidNumber(String laorenUuidNumber) {
						this.laorenUuidNumber = laorenUuidNumber;
					}
					/**
					* 获取： 老人姓名
					*/
					public String getLaorenName() {
						return laorenName;
					}
					/**
					* 设置： 老人姓名
					*/
					public void setLaorenName(String laorenName) {
						this.laorenName = laorenName;
					}
					/**
					* 获取： 老人手机号
					*/
					public String getLaorenPhone() {
						return laorenPhone;
					}
					/**
					* 设置： 老人手机号
					*/
					public void setLaorenPhone(String laorenPhone) {
						this.laorenPhone = laorenPhone;
					}
					/**
					* 获取： 老人照片
					*/
					public String getLaorenPhoto() {
						return laorenPhoto;
					}
					/**
					* 设置： 老人照片
					*/
					public void setLaorenPhoto(String laorenPhoto) {
						this.laorenPhoto = laorenPhoto;
					}
					/**
					* 获取： 年龄
					*/
					public Integer getNianling() {
						return nianling;
					}
					/**
					* 设置： 年龄
					*/
					public void setNianling(Integer nianling) {
						this.nianling = nianling;
					}
					/**
					* 获取： 联系方式
					*/
					public String getLaorenAddress() {
						return laorenAddress;
					}
					/**
					* 设置： 联系方式
					*/
					public void setLaorenAddress(String laorenAddress) {
						this.laorenAddress = laorenAddress;
					}
					/**
					* 获取： 身份证号
					*/
					public String getLaorenIdNumber() {
						return laorenIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setLaorenIdNumber(String laorenIdNumber) {
						this.laorenIdNumber = laorenIdNumber;
					}
					/**
					* 获取： 亲属姓名
					*/
					public String getQinshuxingming() {
						return qinshuxingming;
					}
					/**
					* 设置： 亲属姓名
					*/
					public void setQinshuxingming(String qinshuxingming) {
						this.qinshuxingming = qinshuxingming;
					}
					/**
					* 获取： 亲属联系方式
					*/
					public String getQinshuxingmingPhone() {
						return qinshuxingmingPhone;
					}
					/**
					* 设置： 亲属联系方式
					*/
					public void setQinshuxingmingPhone(String qinshuxingmingPhone) {
						this.qinshuxingmingPhone = qinshuxingmingPhone;
					}
					/**
					* 获取： 医疗卡号
					*/
					public String getYiliaokahao() {
						return yiliaokahao;
					}
					/**
					* 设置： 医疗卡号
					*/
					public void setYiliaokahao(String yiliaokahao) {
						this.yiliaokahao = yiliaokahao;
					}








}
