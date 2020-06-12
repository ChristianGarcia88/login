package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.Usuario;

public interface Repo  extends CrudRepository<Usuario, Integer>{

	@Query("from Usuario  u where u.nombre=?1")
	Usuario findByNombre(String  nombre);
}
 