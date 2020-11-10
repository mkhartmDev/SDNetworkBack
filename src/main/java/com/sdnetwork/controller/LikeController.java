package com.sdnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdnetwork.service.LikeService;

@Controller
@CrossOrigin
@RequestMapping("/likes")
public class LikeController {
	
	@Autowired
	public LikeController(LikeService ls) {
		super();
		this.ls = ls;
	}
	
	public LikeController() {
		this(new LikeService());
	}

	private LikeService ls;
	
	@PostMapping("/add/{postId}")
	public void addLike(@RequestParam("userId") int userId,@PathVariable("postId") int postId) {
		ls.addLike(userId,postId);
		
	}
	
	@PostMapping("/remove/{postId}")
	public void removeLike(@RequestParam("userId") int userId,@PathVariable("postId") int postId) {
		ls.removeLike(userId,postId);
	}

}