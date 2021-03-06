package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_video_collect")
public class UserVideoCollect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6821961161666445312L;	
	
		
	/**
	 *  视频已收藏
	 * 
	 */
	public static final int VIDEO_COLLECTION_STATUS = 1;
    	
	/**
	 *  视频未收藏
	 * 
	 */
	public static final int VIDEO_NOT_COLLECTION_STATUS = 2;
    	
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  Long articleId;
	
  	 
    private  int collectionTag;
	
  	 
    private  Long collectAt;
	
  
	
		 	
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
		 	@Column(name = "video_id")
	public Long getArticleId() {
		return articleId;
	}
	
	
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
		 	@Column(name = "collection_tag")
	public int getCollectionTag() {
		return collectionTag;
	}
	
	
	public void setCollectionTag(int collectionTag) {
		this.collectionTag = collectionTag;
	}
		 	@Column(name = "collection_at")
	public Long getCollectAt() {
		return collectAt;
	}
	
	
	public void setCollectAt(Long collectAt) {
		this.collectAt = collectAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

