package com.app.secondDoctrinaBackEnd.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.secondDoctrinaBackEnd.domain.Administrador;

@RestController
@RequestMapping(value = "/adm")
public class AdministradorResource {

	// mostra o unico adm do sistema
	@RequestMapping(method=RequestMethod.GET)
	public Administrador listar() {
		Administrador adm = new Administrador(1, "admin", "admin@gmail.com", "foto aqui");
		//Administrador adm2 = new Administrador(2, "juliana adm", "juliana2@gmail.com", "foto aq");
		
		return adm;
	}
}
