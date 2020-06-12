package com.example.securityconfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.Usuario;
import com.example.repository.Repo;
@Service
public class ImplementacionServiceDetail  implements UserDetailsService {

	
	@Autowired
	private  Repo  repositorio;




public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
	Usuario usuario=repositorio.findByNombre(nombre);
String  d =	usuario.getNombre();

if(d==null) {throw   new UsernameNotFoundException("No autorized ");}
	GrantedAuthority  derechos= new SimpleGrantedAuthority(usuario.getRoles()) ;
	
	System.out.println( usuario.getNombre());
	System.out.println( usuario.getContrasena());
	System.out.println( usuario.getRoles());
	
	User usuarioConvertido= new User(usuario.getNombre(), usuario.getContrasena(), Arrays.asList(derechos));
	UserDetails user= (UserDetails) usuarioConvertido;

	System.out.println( user.getUsername());
	System.out.println( user.getPassword());
	System.out.println( user.getAuthorities());
	
	return user;
}
}
