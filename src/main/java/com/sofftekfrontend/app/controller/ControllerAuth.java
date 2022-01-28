package com.sofftekfrontend.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Usuario;
import com.sofftekfrontend.app.repository.RepositorioUsuario;
import com.sofftekfrontend.app.util.JWTUtil;
@CrossOrigin(origins ="https://retail-facu-sofftek-frontend.herokuapp.com/")
@RestController
public class ControllerAuth {
	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private RepositorioUsuario repo;

	@PostMapping("/usuario/login")
	public String getUsuarioByUsername(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioLoggeado =  repo.findByUsername(usuario.getUsername());
		if (usuarioLoggeado!=null) {
			if(usuarioLoggeado.getPassword().equals(usuario.getPassword())) {
				String tokenJwt =jwtUtil.create(String.valueOf(usuarioLoggeado.getId()), usuarioLoggeado.getRol().toString());
				return tokenJwt;
			}else {
				return "BADPASSWORD";
			}
		}
		return "ERROR";
	}
	private boolean validarToken(String token) {
		String idUsuario = jwtUtil.getKey(token);
			return !(idUsuario == null);
	}
}
