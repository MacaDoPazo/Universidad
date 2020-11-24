package ar.edu.dopazo.Universidad.Controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.dopazo.Universidad.Modelos.Materia;
import ar.edu.dopazo.Universidad.Modelos.Profesor;
import ar.edu.dopazo.Universidad.Modelos.Usuario_Materia;
import ar.edu.dopazo.Universidad.Servicios.ServicioMateria;


@Controller
public class ControladorMateria {

	@Inject
	private ServicioMateria servicioMateria;
	@RequestMapping(path = "/detalle", method = RequestMethod.GET)
	public ModelAndView detalleMateria(@RequestParam("idMateria") Long idMateria,
			HttpServletRequest request) {
		String rol = (String) request.getSession().getAttribute("usuario_rol");
		if(rol.equals("alumno"))
		{
			Materia materia = servicioMateria.buscarMateriaPorId(idMateria);
			ModelMap model = new ModelMap();
			model.put("materia",materia);
			return new ModelAndView("detalleMateria", model);
		}
		else
		{
			return new ModelAndView("index");
		}
	}
	@RequestMapping(path = "/anotarse", method = RequestMethod.POST)
	public ModelAndView anotarse(@RequestParam("idMateria") Long idMateria,
			@RequestParam("dni") Long dni,
			HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("alumno"))
		{
		try {
			servicioMateria.anotarseAmateria(idMateria,dni);
		}
		catch (Exception e) {
			
			Materia materia = servicioMateria.buscarMateriaPorId(idMateria);
			ModelMap model = new ModelMap();
			model.put("materia",materia);
			model.put("error",e.getMessage());
			return new ModelAndView("detalleMateria", model);
		}
		 
		ModelMap model = new ModelMap();
		List<Materia> listarMaterias = servicioMateria.listarMateriasDisponibles();
		
		model.put("listaMaterias",listarMaterias);
		return new ModelAndView("index", model);
		}
		else
		{
			return new ModelAndView("index");
		}
	}
	@RequestMapping(path = "/listarMateriasAnotadas")
	public ModelAndView anotarse(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("alumno"))
		{	
		Long dni = (Long) request.getSession().getAttribute("usuario_dni");
		ModelMap model = new ModelMap();
		try {
			List<Usuario_Materia> listaMaterasAnotadas = servicioMateria.listarMateriasAnotadas(dni);
			List<Materia> listarMaterias = servicioMateria.listarMateriasDisponibles();
			model.put("listaMateriasAnotadas",listaMaterasAnotadas);
			return new ModelAndView("materiasAnotadas", model);
		}
		catch (Exception e) {
			
			model.put("error",e.getMessage());
			return new ModelAndView("materiasAnotadas", model);
		}
		}
		else
		{
			return new ModelAndView("index");
		}
		
		
	}
	@RequestMapping(path = "/listarMaterias")
	public ModelAndView listarMaterias(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("Admin"))
		{	
		List<Materia>listaMaterias = servicioMateria.listarMaterias();
		ModelMap model = new ModelMap();
		model.put("listaMaterias",listaMaterias);
		return new ModelAndView("listaDeMaterias", model);
		}
		
			return new ModelAndView("index");
		
		
	}
	@RequestMapping(path = "/materiaNueva")
	public ModelAndView materiaNueva(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("Admin"))
		{	
		
		List<Profesor> listaProfesores = servicioMateria.listarProfesores();
		
		ModelMap model = new ModelMap();
		model.put("listaProfesores",listaProfesores);
		return new ModelAndView("materiaNueva", model);
		}
		else
		{
			return new ModelAndView("index");
		}
		
	}
	@RequestMapping(path = "/guardarMateria")
	public ModelAndView guardarMateria(@RequestParam("nombre") String nombre,
			@RequestParam("capacidad") Integer capacidad,
			@RequestParam("horario") String horario,
			@RequestParam("dni") Integer dniProfe,
			HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("Admin"))
		{	
		Materia materia = new Materia();
		materia.setNombre(nombre);
		materia.setMaximoAlumnos(capacidad);
		materia.setHorario(horario);
		Profesor profesor = servicioMateria.buscarProfesorPorDni(dniProfe);
		materia.setProfesor(profesor);
		servicioMateria.guardarMateria(materia);
		List<Materia>listaMaterias = servicioMateria.listarMaterias();
		ModelMap model = new ModelMap();
		model.put("listaMaterias",listaMaterias);
		return new ModelAndView("listaDeMaterias", model);
		}
		else
		{
			return new ModelAndView("index");
		}
		
	}
	@RequestMapping(path = "/listarProfesores")
	public ModelAndView listarProfesores(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("Admin"))
		{	
		List<Profesor>listaProfesores = servicioMateria.listarProfesores();
		ModelMap model = new ModelMap();
		model.put("listaProfesores",listaProfesores);
		return new ModelAndView("listaDeProfesores", model);
		}
		else
		{
			return new ModelAndView("index");
		}
		
	}
	@RequestMapping(path = "/profesorNuevo")
	public ModelAndView profesorNuevo(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("Admin"))
		{	
			return new ModelAndView("profesorNuevo");
		}
		else
		{
			return new ModelAndView("index");
		}
		
	}
	@RequestMapping(path = "/guardarProfesor")
	public ModelAndView guardarProfesor(@RequestParam("dni") Integer dni,
			@RequestParam("apellido") String apellido,
			@RequestParam("nombre") String nombre,
			@RequestParam("estado") String estado,
			HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuario_rol").equals("Admin"))
		{
		Profesor profesor = new Profesor();
		profesor.setDni(dni);
		profesor.setApellido(apellido);
		profesor.setNombre(nombre);
		profesor.setEstado(estado);
		servicioMateria.guardarProfesor(profesor);
		List<Profesor>listaProfesores = servicioMateria.listarProfesores();
		ModelMap model = new ModelMap();
		model.put("listaProfesores",listaProfesores);
		return new ModelAndView("listaDeProfesores", model);
		}
		else
		{
			return new ModelAndView("index");
		}
		
	}
}
