package ar.edu.dopazo.Universidad.Controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.dopazo.Universidad.Modelos.Materia;
import ar.edu.dopazo.Universidad.Servicios.ServicioMateria;

@Controller
public class ControladorInicio {

	@Inject
	private ServicioMateria servicioMateria;
	@RequestMapping("/inicio")
	public ModelAndView irAInicio(HttpServletRequest request)
	{
		Long dni = (Long) request.getSession().getAttribute("usuario_dni");
		ModelMap model = new ModelMap();
		if(dni != null)
		{
			List<Materia> listarMaterias = servicioMateria.listarMateriasDisponibles();
			model.put("listaMaterias",listarMaterias);
			return new ModelAndView("index",model);
		}
		else
		{
			return new ModelAndView("index");
		}
	}
	
}
