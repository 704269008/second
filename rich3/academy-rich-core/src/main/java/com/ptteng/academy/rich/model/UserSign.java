package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_sign")
public class UserSign implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2120043035255673856L;	
	
		
	/**
	 *  已签到
	 * 
	 */
	public static final int SIGN_TAG = 1;
    	
	/**
	 *  未签到
	 * 
	 */
	public static final int NOT_SIGN_TAG = 0;
    	
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  int beans;
	
  	 
    private  int totalSign;
	
  	 
    private  int maxSign;
	
  	 
    private  int continuousSign;
	
  	 
    private  String signSet;
	
  	 
    private  int recordSign;
	
  	 
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
		 	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}
	
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
		 	@Column(name = "beans")
	public int getBeans() {
		return beans;
	}
	
	
	public void setBeans(int beans) {
		this.beans = beans;
	}
		 	@Column(name = "total_sign")
	public int getTotalSign() {
		return totalSign;
	}
	
	
	public void setTotalSign(int totalSign) {
		this.totalSign = totalSign;
	}
		 	@Column(name = "max_sign")
	public int getMaxSign() {
		return maxSign;
	}
	
	
	public void setMaxSign(int maxSign) {
		this.maxSign = maxSign;
	}
		 	@Column(name = "continuous_sign")
	public int getContinuousSign() {
		return continuousSign;
	}
	
	
	public void setContinuousSign(int continuousSign) {
		this.continuousSign = continuousSign;
	}
		 	@Column(name = "sign_set")
	public String getSignSet() {
		return signSet;
	}
	
	
	public void setSignSet(String signSet) {
		this.signSet = signSet;
	}
		 	@Column(name = "record_sign")
	public int getRecordSign() {
		return recordSign;
	}
	
	
	public void setRecordSign(int recordSign) {
		this.recordSign = recordSign;
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

