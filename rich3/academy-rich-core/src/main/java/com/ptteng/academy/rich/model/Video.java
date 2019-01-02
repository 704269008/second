package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "video")
public class Video implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3007443874713391104L;	
	
		
	/**
	 *  视频类型-banner视频
	 * 
	 */
	public static final int BANNER_VIDEO = 1;
    	
	/**
	 *  视频类型-card视频
	 * 
	 */
	public static final int CARD_VIDEO = 2;
    	
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
	 *  所有状态
	 * 
	 */
	public static final int ALL_STATUS = 0;
    	
	/**
	 *  最大BANNER图上架数
	 * 
	 */
	public static final int MAX_BANNER_NUMBER = 8;
    	
	/**
	 *  语文
	 * 
	 */
	public static final int CHINESE = 1;
    	
	/**
	 *  数学
	 * 
	 */
	public static final int MATH = 2;
    	
	/**
	 *  英语
	 * 
	 */
	public static final int ENGLISH = 3;
    	
	/**
	 *  物理
	 * 
	 */
	public static final int PHYSICS = 4;
    	
	/**
	 *  化学
	 * 
	 */
	public static final int CHEMISTRY = 5;
    	
	/**
	 *  生物
	 * 
	 */
	public static final int BIOLOGY = 6;
    	
	/**
	 *  历史
	 * 
	 */
	public static final int HISTORY = 7;
    	
	/**
	 *  地理
	 * 
	 */
	public static final int GEOGRAPHY = 8;
    	
	/**
	 *  政治
	 * 
	 */
	public static final int POLITICS = 9;
    	
	/**
	 *  全部科目
	 * 
	 */
	public static final int ALL_SUBJECT = 0;
    	
   	 
    private  Long id;

    private  Long teacherId;
	
  	 
    private  String title;
	
  	 
    private  int type;
	
  	 
    private  String img;
	
  	 
    private  String url;
	
  	 
    private  int grade;
	
  	 
    private  int subject;
	
  	 
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

	        @Column(name = "teacher_id")
	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
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
		 	@Column(name = "img")
	public String getImg() {
		return img;
	}
	
	
	public void setImg(String img) {
		this.img = img;
	}
		 	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}
		 	@Column(name = "grade")
	public int getGrade() {
		return grade;
	}
	
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
		 	@Column(name = "subject")
	public int getSubject() {
		return subject;
	}
	
	
	public void setSubject(int subject) {
		this.subject = subject;
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

