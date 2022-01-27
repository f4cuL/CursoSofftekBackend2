package com.sofftekfrontend.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Usuario;
import com.sofftekfrontend.app.repository.RepositorioUsuario;
import com.sofftekfrontend.app.util.JWTUtil;

@RestController
public class ControllerAuth {
	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private RepositorioUsuario repo;

//	@RequestMapping(value="api/login", method = RequestMethod.POST)
//	public String iniciarSesion(@RequestBody Usuario usuario) {
//		Usuario usuarioLoggeado = usuarioDao.obtenerUsuarioPorVerificacion(usuario);
//		if (usuarioLoggeado!=null) {
//			String tokenJwt =jwtUtil.create(String.valueOf(usuarioLoggeado.getId()), usuarioLoggeado.getEmail());
//			return tokenJwt;
//		}
//		return "fail";
//}
	@PostMapping("/usuario/login")
	public String getUsuarioByUsername(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioLoggeado =  repo.findByUsername(usuario.getUsername());
		if (usuarioLoggeado!=null) {
			if(usuarioLoggeado.getPassword().equals(usuario.getPassword())) {
				String tokenJwt =jwtUtil.create(String.valueOf(usuarioLoggeado.getId()), usuarioLoggeado.getRol().toString());
				System.out.println(jwtUtil.getValue(tokenJwt));
				System.out.println(jwtUtil.getKey(tokenJwt));
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
