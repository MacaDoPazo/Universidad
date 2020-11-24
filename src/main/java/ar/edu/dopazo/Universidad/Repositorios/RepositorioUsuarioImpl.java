package ar.edu.dopazo.Universidad.Repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.dopazo.Universidad.Modelos.*;

@Repository
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	@Inject
	SessionFactory sesion;
	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return (Usuario) sesion.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("dni", usuario.getDni()))
				.add(Restrictions.eq("legajo", usuario.getLegajo()))
				.uniqueResult();
	}
	@Override
	public Usuario buscarUsuarioPorDni(Long dni) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().get(Usuario.class, dni);
	}

}
