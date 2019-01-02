package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "article")
public class Article implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1428772232135571456L;	
	
		
	/**
	 *  文章类型-banner文章
	 * 
	 */
	public static final int BANNER_ARTICLE = 1;
    	
	/**
	 *  文章类型-card文章
	 * 
	 */
	public static final int CARD_ARTICLE = 2;
    	
	/**
	 *  上架状态
	 * 
	 */
	public static final int SHELVES = 1;
    	
	/**
	 *  下架状态
	 * 
	 */
	public static final int PULL_OFF_SHELVES = 2;
    	
	/**
	 *  全部状态
	 * 
	 */
	public static final int ALL_STATUS = 0;
    	
	/**
	 *  最大BANNER图上架数
	 * 
	 */
	public static final int MAX_BANNER_NUMBER = 8;
    	
   	 
    private  Long id;
	
  	 
    private  String title;
	
  	 
    private  int type;
	
  	 
    private  String cover;
	
  	 
    private  String writer;
	
  	 
    private  String summary;
	
  	 
    private  String content;
	
  	 
    private  int collection;
	
  	 
    private  int upvote;
	
  	 
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
		 	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
		 	@Column(name = "type")
	public int getType() {
		return type;
	}
	
	
	public void setType(int type) {
		this.type = type;
	}
		 	@Column(name = "cover")
	public String getCover() {
		return cover;
	}
	
	
	public void setCover(String cover) {
		this.cover = cover;
	}
		 	@Column(name = "writer")
	public String getWriter() {
		return writer;
	}
	
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
		 	@Column(name = "summary")
	public String getSummary() {
		return summary;
	}
	
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
		 	@Column(name = "collection")
	public int getCollection() {
		return collection;
	}
	
	
	public void setCollection(int collection) {
		this.collection = collection;
	}
		 	@Column(name = "upvote")
	public int getUpvote() {
		return upvote;
	}
	
	
	public void setUpvote(int upvote) {
		this.upvote = upvote;
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

