package ar.edu.dopazo.Universidad.Servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.dopazo.Universidad.Modelos.*;

@Service
@Transactional
public interface ServicioMateria {

	List<Materia> listarMateriasDisponibles();

	Materia buscarMateriaPorId(Long idMateria);

	void anotarseAmateria(Long idMateria, Long dni) throws Exception;

	List<Usuario_Materia> listarMateriasAnotadas(Long dni) throws Exception;

	List<Materia> listarMaterias();

	Profesor buscarProfesorPorDni(Integer dniProfe);

	void guardarMateria(Materia materia);

	List<Profesor> listarProfesores();

}
