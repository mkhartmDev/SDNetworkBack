package com.sdnetwork.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdnetwork.model.Post;
import com.sdnetwork.service.PostService;

@Controller
@CrossOrigin
public class PostController {
	
	private PostService ps;
	
	@Autowired
	public PostController(PostService ps) {
		super();
		this.ps = ps;
	}
	
	public PostController() {
		this(new PostService());
	}
	
	@GetMapping("/posts/all")
	public @ResponseBody List<Post> getAllPosts() {
		return ps.getAll();
		
	}
	
	@GetMapping("/posts/userid/{id}")
	public @ResponseBody List<Post> getPostsByUserId(@PathVariable("id") int id){
		return ps.getById(id);
	
	}
	
	@PostMapping("/posts/new")
	public @ResponseBody Post createNewPost(@RequestBody Post p) {
		return ps.createNew(p);
		
		
	}
	
	
	
	
	
		

}
