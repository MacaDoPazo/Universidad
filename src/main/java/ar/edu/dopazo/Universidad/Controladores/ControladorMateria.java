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

import ar.edu.dopazo.Universidad.Modelos.*;
import ar.edu.dopazo.Universidad.Servicios.*;
@Controller
public class ControladorMateria {

	@Inject
	private ServicioMateria servicioMateria;
	@RequestMapping(path = "/detalle", method = RequestMethod.GET)
	public ModelAndView detalleMateria(@RequestParam("idMateria") Long idMateria) {
		Materia materia = servicioMateria.buscarMateriaPorId(idMateria);
		ModelMap model = new ModelMap();
		model.put("materia",materia);
		return new ModelAndView("detalleMateria", model);
	}
	@RequestMapping(path = "/anotarse", method = RequestMethod.POST)
	public ModelAndView anotarse(@RequestParam("idMateria") Long idMateria,
			@RequestParam("dni") Long dni) {
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
}
