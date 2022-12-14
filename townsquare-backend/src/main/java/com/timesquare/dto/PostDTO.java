package com.timesquare.dto;

import java.util.List;

import com.timesquare.models.Comment;
import com.timesquare.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	
	private long postId;
	private String title;
	private String description;
	private long likes;
	private long dislikes;
	private long shares;
	private String imageUrl;
	private java.sql.Date date;
	private User user;
	private List<Comment> comments;

}
