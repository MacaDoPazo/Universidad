package ar.edu.dopazo.Universidad.Repositorios;

import ar.edu.dopazo.Universidad.Modelos.Usuario;

public interface RepositorioUsuario {

	Usuario consultarUsuario(Usuario usuario);

	Usuario buscarUsuarioPorDni(Long dni);

}
