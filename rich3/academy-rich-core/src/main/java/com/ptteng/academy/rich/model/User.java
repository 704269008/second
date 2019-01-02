package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5240532930025943040L;	
	
		
	/**
	 *  初一
	 * 
	 */
	public static final int JUNIOR_GRADE_ONE = 1;
    	
	/**
	 *  初二
	 * 
	 */
	public static final int JUNIOR_GRADE_TWO = 2;
    	
	/**
	 *  初三
	 * 
	 */
	public static final int JUNIOR_GRADE_THREE = 3;
    	
	/**
	 *  高一
	 * 
	 */
	public static final int SENIOR_GRADE_ONE = 4;
    	
	/**
	 *  高二
	 * 
	 */
	public static final int SENIOR_GRADE_TWO = 5;
    	
	/**
	 *  高三
	 * 
	 */
	public static final int SENIOR_GRADE_THREE = 6;
    	
	/**
	 *  全部
	 * 
	 */
	public static final int GRADE_ALL = 0;
    	
	/**
	 *  正常状态
	 * 
	 */
	public static final int NOT_FROZEN_STATE = 1;
    	
	/**
	 *  冻结状态
	 * 
	 */
	public static final int FROZEN_STATE = 2;
    	
	/**
	 *  已绑定
	 * 
	 */
	public static final int NOT_BIND_STATE = 1;
    	
	/**
	 *  未绑定
	 * 
	 */
	public static final int BIND_STATE = 2;
    	
   	 
    private  Long id;
	
  	 
    private  String openid;
	
  	 
    private  String name;
	
  	 
    private  int grade;
	
  	 
    private  String avatar;
	
  	 
    private  String phone;
	
  	 
    private  String email;
	
  	 
    private  String area;
	
  	 
    private  int status;
	
  	 
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
		 	@Column(name = "openid")
	public String getOpenid() {
		return openid;
	}
	
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "grade")
	public int getGrade() {
		return grade;
	}
	
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
		 	@Column(name = "avatar")
	public String getAvatar() {
		return avatar;
	}
	
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
		 	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
		 	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
		 	@Column(name = "area")
	public String getArea() {
		return area;
	}
	
	
	public void setArea(String area) {
		this.area = area;
	}
		 	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	
	
	public void setStatus(int status) {
		this.status = status;
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
		 	@Column(name = "creat_at")
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

