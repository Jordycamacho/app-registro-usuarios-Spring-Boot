package com.example.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.entity.Usuarios;
import com.example.spring.service.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	@Qualifier("usuariosservice")
	private UsuariosService usuariosService;
	
	@GetMapping("/usersform")
	public String UsersForm(Model model, @RequestParam(name = "id", required = true) int id) {
		
		Usuarios us = new Usuarios();
		
		if (id!=0) {
			
			us = usuariosService.findUsuariosById(id);
		
		}
		
		model.addAttribute("usuarios", us);
		
		return"usersform";
		
	}
	
	@PostMapping("/addusuarios")
	public String AddUsuarios(@ModelAttribute(name="usuarios")Usuarios usuarios) {
		
		usuariosService.addUsuarios(usuarios);
		
		return"redirect:/usuarios/listadousers";
	} 
	
	
	
	@GetMapping("/listadousers")
	public ModelAndView ListadoUsers() {
		
		ModelAndView mav = new ModelAndView("users");
		
		mav.addObject("users", usuariosService.ListAllUsuarios());
		
		return mav;
		
	}
	
	@GetMapping("/removeusuarios")
	public ModelAndView removeUsuarios(@RequestParam(name = "id", required = true) int id) {
		
		usuariosService.removeUsuarios(id);
		
		return ListadoUsers();
		
	}
}
