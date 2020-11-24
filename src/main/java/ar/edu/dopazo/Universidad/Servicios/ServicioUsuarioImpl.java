package ar.edu.dopazo.Universidad.Servicios;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.dopazo.Universidad.Modelos.Usuario;
import ar.edu.dopazo.Universidad.Repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private RepositorioUsuario repositorioUsuario;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		
		return repositorioUsuario.consultarUsuario(usuario);
	}
	

}
