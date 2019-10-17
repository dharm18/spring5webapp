package com.vdharam.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vdharam.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}
	
}
