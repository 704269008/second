package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "wechat_data")
public class WechatData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7593980316639466496L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String openId;
	
  	 
    private  String accessToken;
	
  	 
    private  int emailCode;
	
  	 
    private  int phoneCode;
	
  	 
    private  int emailCodeTimes;
	
  	 
    private  int phoneCodeTimes;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "open_id")
	public String getOpenId() {
		return openId;
	}
	
	
	public void setOpenId(String openId) {
		this.openId = openId;
	}
		 	@Column(name = "access_token")
	public String getAccessToken() {
		return accessToken;
	}
	
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
		 	@Column(name = "email_code")
	public int getEmailCode() {
		return emailCode;
	}
	
	
	public void setEmailCode(int emailCode) {
		this.emailCode = emailCode;
	}
		 	@Column(name = "phone_code")
	public int getPhoneCode() {
		return phoneCode;
	}
	
	
	public void setPhoneCode(int phoneCode) {
		this.phoneCode = phoneCode;
	}
		 	@Column(name = "email_code_times")
	public int getEmailCodeTimes() {
		return emailCodeTimes;
	}
	
	
	public void setEmailCodeTimes(int emailCodeTimes) {
		this.emailCodeTimes = emailCodeTimes;
	}
		 	@Column(name = "phone_code_times")
	public int getPhoneCodeTimes() {
		return phoneCodeTimes;
	}
	
	
	public void setPhoneCodeTimes(int phoneCodeTimes) {
		this.phoneCodeTimes = phoneCodeTimes;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

