package ar.edu.dopazo.Universidad.Servicios;

import java.util.List;

import ar.edu.dopazo.Universidad.Modelos.Materia;

public interface ServicioMateria {

	List<Materia> listarMateriasDisponibles();

	Materia buscarMateriaPorId(Long idMateria);

	void anotarseAmateria(Long idMateria, Long dni) throws Exception;

}
