/**
 * 
 */
package ar.edu.dopazo.Universidad.Repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.dopazo.Universidad.Modelos.*;




/**
 * @author Maqui
 *
 */
@Repository
public class RepositorioMateriaImpl implements RepositorioMateria {

	@Autowired
	SessionFactory sesion;
	@Override
	public List<Materia> listarMateriasDisponibles() {
		
		return (List<Materia>) sesion.getCurrentSession().createCriteria(Materia.class).list();
	}
	@Override
	public Materia buscarMateriaPorId(Long idMateria) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().get(Materia.class, idMateria);
	}
	@Override
	public void actualizarMateria(Materia materia) {
		sesion.getCurrentSession().update(materia);
		
	}
	@Override
	public void anotarseAmateria(Usuario_Materia usuario_materia) {
		// TODO Auto-generated method stub
		sesion.getCurrentSession().save(usuario_materia);
	}
	@Override
	public List<Usuario_Materia> listarMateriasAnotadas(Long dni) {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().createCriteria(Usuario_Materia.class)
				.createAlias("usuario", "alumno")
				.add(Restrictions.eq("alumno.dni", dni))
				.list();
	}
	@Override
	public Profesor buscarProfesorPorDni(Integer dniProfe) {
		// TODO Auto-generated method stub
		return (Profesor) sesion.getCurrentSession().createCriteria(Profesor.class)
				.add(Restrictions.eq("dni", dniProfe))
				.uniqueResult();
	}
	@Override
	public void guardarMateria(Materia materia) {
		// TODO Auto-generated method stub
		sesion.getCurrentSession().save(materia);
	}
	@Override
	public List<Profesor> listarProfesores() {
		// TODO Auto-generated method stub
		return sesion.getCurrentSession().createCriteria(Profesor.class)
				.list();
	}
	

}
