/**
 * 
 */
package ar.edu.dopazo.Universidad.Repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.dopazo.Universidad.Modelos.Materia;


/**
 * @author Maqui
 *
 */
@Repository
public class RepositorioMateriaImpl implements RepositorioMateria {

	@Inject
	SessionFactory sesion;
	@Override
	public List<Materia> listarMateriasDisponibles() {
		
		return (List<Materia>) sesion.getCurrentSession().createCriteria(Materia.class).list();
	}

}
