package ar.edu.dopazo.Universidad.Servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.dopazo.Universidad.Modelos.Materia;
import ar.edu.dopazo.Universidad.Modelos.Profesor;
import ar.edu.dopazo.Universidad.Modelos.Usuario;
import ar.edu.dopazo.Universidad.Modelos.Usuario_Materia;
import ar.edu.dopazo.Universidad.Repositorios.RepositorioMateria;
import ar.edu.dopazo.Universidad.Repositorios.RepositorioUsuario;

@Service
@Transactional

public class ServicioMateriaImpl implements ServicioMateria {


	@Inject
	private RepositorioMateria respositorioMateria;
	@Inject
	private RepositorioUsuario respositorioUsuario;
	@Override
	public List<Materia> listarMateriasDisponibles() {
		List<Materia> listaMateria = respositorioMateria.listarMateriasDisponibles();
		List<Materia> listaDisponible = new ArrayList<Materia>();
		for (Materia materia : listaMateria) {
			if(materia.getMaximoAlumnos()!=0)
			{
				listaDisponible.add(materia);
			}
		}
		Collections.sort(listaDisponible, new Comparator<Materia>() {
			   public int compare(Materia mat1, Materia mat2) {
			      return mat1.getNombre().compareTo(mat2.getNombre());
			   }
			});
		return listaDisponible;
	}

	@Override
	public Materia buscarMateriaPorId(Long idMateria) {
		// TODO Auto-generated method stub
		return respositorioMateria.buscarMateriaPorId(idMateria);
	}

	@Override
	public void anotarseAmateria(Long idMateria, Long dni) throws Exception {
		Materia materia = respositorioMateria.buscarMateriaPorId(idMateria);
		Usuario usuario = respositorioUsuario.buscarUsuarioPorDni(dni);
		List<Usuario_Materia>listaMateriaAnotadas = respositorioMateria.listarMateriasAnotadas(dni);
		for (Usuario_Materia usuario_Materia : listaMateriaAnotadas) {
			if(usuario_Materia.getMateria().getHorario().equals(materia.getHorario()))
			{
				throw new Exception("Ya se anoto a una materia en este horario: "+ usuario_Materia.getMateria().getNombre());
			}
		}
		materia.setMaximoAlumnos(materia.getMaximoAlumnos()-1);
		Usuario_Materia usuario_materia = new Usuario_Materia();
		usuario_materia.setMateria(materia);
		usuario_materia.setUsuario(usuario);
		respositorioMateria.actualizarMateria(materia);
		respositorioMateria.anotarseAmateria(usuario_materia);
		
	}

	@Override
	public List<Usuario_Materia> listarMateriasAnotadas(Long dni) throws Exception{
		List<Usuario_Materia> listaMaterias = respositorioMateria.listarMateriasAnotadas(dni);
		if(listaMaterias.size() == 0)
		{
			throw new Exception("No se anoto a ninguna materia");
		}
		Collections.sort(listaMaterias, new Comparator<Usuario_Materia>() {
			   public int compare(Usuario_Materia mat1, Usuario_Materia mat2) {
			      return mat1.getMateria().getNombre().compareTo(mat2.getMateria().getNombre());
			   }
			});
		return listaMaterias;
	}

	@Override
	public List<Materia> listarMaterias() {
		// TODO Auto-generated method stub
		return respositorioMateria.listarMateriasDisponibles();
	}

	@Override
	public Profesor buscarProfesorPorDni(Integer dniProfe) {
		// TODO Auto-generated method stub
		return respositorioMateria.buscarProfesorPorDni(dniProfe);
	}

	@Override
	public void guardarMateria(Materia materia) {
		// TODO Auto-generated method stub
		respositorioMateria.guardarMateria(materia);
	}

	@Override
	public List<Profesor> listarProfesores() {
		// TODO Auto-generated method stub
		return respositorioMateria.listarProfesores();
	}

	@Override
	public void guardarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		respositorioMateria.guardarProfesor(profesor);
	}


}
