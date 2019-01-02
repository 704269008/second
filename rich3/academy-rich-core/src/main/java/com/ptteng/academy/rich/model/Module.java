package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "module")
public class Module implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4954985564407398400L;	
	
		
	/**
	 *  父目录
	 * 
	 */
	public static final int PARENT_DIRECTORY = 0;
    	
	/**
	 *  一级目录
	 * 
	 */
	public static final int FIRST_LEVEL_DIRECTORY = 1;
    	
	/**
	 *  二级目录
	 * 
	 */
	public static final int TWO_LEVEL_DIRECTORY = 2;
    	
	/**
	 *  三级目录
	 * 
	 */
	public static final int THREE_LEVEL_DIRECTORY = 3;
    	
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String url;
	
  	 
    private  int parentId;
	
  	 
    private  int sort;
	
  	 
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
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}
		 	@Column(name = "parent_id")
	public int getParentId() {
		return parentId;
	}
	
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
		 	@Column(name = "sort")
	public int getSort() {
		return sort;
	}
	
	
	public void setSort(int sort) {
		this.sort = sort;
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

