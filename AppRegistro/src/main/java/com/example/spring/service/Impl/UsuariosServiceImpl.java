package com.example.spring.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Usuarios;
import com.example.spring.repository.UsuariosRepository;
import com.example.spring.service.UsuariosService;

@Service("usuariosservice")
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	@Qualifier("usuariosrepository")
	private UsuariosRepository usuariosRepository;
	
	@Override
	public Usuarios addUsuarios(Usuarios usuarios) {
		
		return usuariosRepository.save(usuarios);
	}

	@Override
	public List<Usuarios> ListAllUsuarios() {
		
		List<Usuarios> users = new ArrayList<>();
		
		users = usuariosRepository.findAll();
		
		return users;
	}

	@Override
	public Usuarios findUsuariosById(int id) {
		
		return usuariosRepository.findById(id);
		
	}

	@Override
	public void removeUsuarios(int id) {
		
		Usuarios us = findUsuariosById(id);
		
		if (null != us) {
			
			usuariosRepository.delete(us);
		
		}
		
	} 
	
	
	
}
