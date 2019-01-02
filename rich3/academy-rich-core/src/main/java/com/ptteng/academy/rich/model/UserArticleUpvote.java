package com.ptteng.academy.rich.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_article_upvote")
public class UserArticleUpvote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2289335950966522880L;	
	
		
	/**
	 *  文章已点赞
	 * 
	 */
	public static final int ARTICLE_UPVOTE_STATUS = 1;
    	
	/**
	 *  文章未点赞
	 * 
	 */
	public static final int ARTICLE_NOT_UPVOTE_STATUS = 2;
    	
   	 
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
		 	@Column(name = "article_id")
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

