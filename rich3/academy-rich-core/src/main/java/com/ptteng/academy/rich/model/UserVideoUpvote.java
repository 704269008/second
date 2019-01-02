package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_video_upvote")
public class UserVideoUpvote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3004394265892062208L;	
	
		
	/**
	 *  视频已点赞
	 * 
	 */
	public static final int VIDEO_UPVOTE_STATUS = 1;
    	
	/**
	 *  视频未点赞
	 * 
	 */
	public static final int VIDEO_NOT_UPVOTE_STATUS = 2;
    	
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  Long articleId;
	
  	 
    private  int upvoteTag;
	
  	 
    private  Long upvoteAt;
	
  
	
		 	
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
		 	@Column(name = "upvote_tag")
	public int getUpvoteTag() {
		return upvoteTag;
	}
	
	
	public void setUpvoteTag(int upvoteTag) {
		this.upvoteTag = upvoteTag;
	}
		 	@Column(name = "upvote_at")
	public Long getUpvoteAt() {
		return upvoteAt;
	}
	
	
	public void setUpvoteAt(Long upvoteAt) {
		this.upvoteAt = upvoteAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

