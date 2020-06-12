package com.example.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ControladorLogin {

	 @GetMapping("/login")
	 public String inicio( Model m, String error, String logout) {
		 if(error !=null) {m.addAttribute("error", "error password o contraseña");}
		 if(logout !=null) {m.addAttribute("logout", "se ha deslogueado");}
		 
		 
		 
		 return "login";  
		  
	 }
	  
	 
	 @GetMapping("/seguro/permiso")
	 public String  permiso(Model m )
	 {
		m.addAttribute("lista", Arrays.asList("Curso Spring", "Curso Java", "Curso lo que sea"));
		 
		 return "permiso";
		 
	 }	
	
	}
