package com.timesquare.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.timesquare.dto.PostDTO;
import com.timesquare.models.Post;
import com.timesquare.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping()
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}
	
	@GetMapping("/{userId}")
	public List<Post> getAllUserPosts(@PathVariable Long userId) {
		return postService.getAllUserPosts(userId);
	}
	
	@GetMapping("/id/{postId}")
	public Post getPostById(@PathVariable Long postId) throws Exception {
		return postService.getPostById(postId);
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public String addPost(@RequestBody PostDTO postDTO) {
		Post post = dtoToEntity(postDTO);
		return postService.addPost(post);
	}
	
	@PutMapping("/update")
	public String updatePost(@RequestBody PostDTO postDTO) {
		Post post = dtoToEntity(postDTO);
		return postService.updatePost(post);
	}
	
	@DeleteMapping("/delete/{postId}")
	public String deletePost(@PathVariable Long postId) {
		return postService.deletePost(postId);
	}

	private Post dtoToEntity(PostDTO postDTO) {
		Post post = modelMapper.map(postDTO, Post.class);
		return post;
	}
}
