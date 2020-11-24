package ar.edu.dopazo.Universidad.Servicios;

import java.util.List;

import ar.edu.dopazo.Universidad.Modelos.Materia;
import ar.edu.dopazo.Universidad.Modelos.Profesor;
import ar.edu.dopazo.Universidad.Modelos.Usuario_Materia;

public interface ServicioMateria {

	List<Materia> listarMateriasDisponibles();

	void anotarseAmateria(Long idMateria, Long dni) throws Exception;

	Materia buscarMateriaPorId(Long idMateria);

	List<Usuario_Materia> listarMateriasAnotadas(Long dni) throws Exception;

	List<Materia> listarMaterias();

	Profesor buscarProfesorPorDni(Integer dniProfe);

	List<Profesor> listarProfesores();

	void guardarMateria(Materia materia);

	void guardarProfesor(Profesor profesor);

}
