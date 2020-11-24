package ar.edu.dopazo.Universidad.Servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.dopazo.Universidad.Modelos.Materia;
import ar.edu.dopazo.Universidad.Repositorios.RepositorioMateria;
@Service
@Transactional
public class ServicioMateriaImpl implements ServicioMateria {

	@Inject
	private RepositorioMateria respositorioMateria;

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

}
