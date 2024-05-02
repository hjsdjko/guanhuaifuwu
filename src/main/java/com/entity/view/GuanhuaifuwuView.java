package com.entity.view;

import com.entity.GuanhuaifuwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 关怀服务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("guanhuaifuwu")
public class GuanhuaifuwuView extends GuanhuaifuwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 服务类型的值
		*/
		private String guanhuaifuwuValue;
		/**
		* 状态的值
		*/
		private String wanchengValue;
		/**
		* 评价等级的值
		*/
		private String pingjiaValue;



		//级联表 fuwurenyuan
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
			* 服务人员电子邮箱
			*/
			private String fuwurenyuanEmail;

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

	public GuanhuaifuwuView() {

	}

	public GuanhuaifuwuView(GuanhuaifuwuEntity guanhuaifuwuEntity) {
		try {
			BeanUtils.copyProperties(this, guanhuaifuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 服务类型的值
			*/
			public String getGuanhuaifuwuValue() {
				return guanhuaifuwuValue;
			}
			/**
			* 设置： 服务类型的值
			*/
			public void setGuanhuaifuwuValue(String guanhuaifuwuValue) {
				this.guanhuaifuwuValue = guanhuaifuwuValue;
			}
			/**
			* 获取： 状态的值
			*/
			public String getWanchengValue() {
				return wanchengValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setWanchengValue(String wanchengValue) {
				this.wanchengValue = wanchengValue;
			}
			/**
			* 获取： 评价等级的值
			*/
			public String getPingjiaValue() {
				return pingjiaValue;
			}
			/**
			* 设置： 评价等级的值
			*/
			public void setPingjiaValue(String pingjiaValue) {
				this.pingjiaValue = pingjiaValue;
			}







				//级联表的get和set fuwurenyuan
					/**
					* 获取： 服务人员编号
					*/
					public String getFuwurenyuanUuidNumber() {
						return fuwurenyuanUuidNumber;
					}
					/**
					* 设置： 服务人员编号
					*/
					public void setFuwurenyuanUuidNumber(String fuwurenyuanUuidNumber) {
						this.fuwurenyuanUuidNumber = fuwurenyuanUuidNumber;
					}
					/**
					* 获取： 服务人员姓名
					*/
					public String getFuwurenyuanName() {
						return fuwurenyuanName;
					}
					/**
					* 设置： 服务人员姓名
					*/
					public void setFuwurenyuanName(String fuwurenyuanName) {
						this.fuwurenyuanName = fuwurenyuanName;
					}
					/**
					* 获取： 服务人员手机号
					*/
					public String getFuwurenyuanPhone() {
						return fuwurenyuanPhone;
					}
					/**
					* 设置： 服务人员手机号
					*/
					public void setFuwurenyuanPhone(String fuwurenyuanPhone) {
						this.fuwurenyuanPhone = fuwurenyuanPhone;
					}
					/**
					* 获取： 服务人员头像
					*/
					public String getFuwurenyuanPhoto() {
						return fuwurenyuanPhoto;
					}
					/**
					* 设置： 服务人员头像
					*/
					public void setFuwurenyuanPhoto(String fuwurenyuanPhoto) {
						this.fuwurenyuanPhoto = fuwurenyuanPhoto;
					}
					/**
					* 获取： 服务人员电子邮箱
					*/
					public String getFuwurenyuanEmail() {
						return fuwurenyuanEmail;
					}
					/**
					* 设置： 服务人员电子邮箱
					*/
					public void setFuwurenyuanEmail(String fuwurenyuanEmail) {
						this.fuwurenyuanEmail = fuwurenyuanEmail;
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
