package ar.edu.dopazo.Universidad.Repositorios;

import java.util.List;

import ar.edu.dopazo.Universidad.Modelos.Materia;
import ar.edu.dopazo.Universidad.Modelos.Profesor;
import ar.edu.dopazo.Universidad.Modelos.Usuario_Materia;

public interface RepositorioMateria {

	List<Materia> listarMateriasDisponibles();

	Materia buscarMateriaPorId(Long idMateria);

	void actualizarMateria(Materia materia);

	void anotarseAmateria(Usuario_Materia usuario_materia);

	List<Usuario_Materia> listarMateriasAnotadas(Long dni);

	Profesor buscarProfesorPorDni(Integer dniProfe);

	void guardarMateria(Materia materia);

	List<Profesor> listarProfesores();

	void guardarProfesor(Profesor profesor);

}
