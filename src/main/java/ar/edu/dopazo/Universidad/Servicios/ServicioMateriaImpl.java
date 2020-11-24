package ar.edu.dopazo.Universidad.Servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.dopazo.Universidad.Modelos.*;

import ar.edu.dopazo.Universidad.Repositorios.*;
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

}
