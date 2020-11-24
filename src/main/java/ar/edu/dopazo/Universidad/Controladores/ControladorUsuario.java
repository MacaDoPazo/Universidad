package ar.edu.dopazo.Universidad.Controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.dopazo.Universidad.Modelos.Materia;
import ar.edu.dopazo.Universidad.Modelos.Usuario;
import ar.edu.dopazo.Universidad.Servicios.ServicioMateria;
import ar.edu.dopazo.Universidad.Servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioUsuario servicioUsuario;
	@Inject 
	private ServicioMateria servicioMateria;
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		Usuario usuarioBuscado = servicioUsuario.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("usuario_dni", usuarioBuscado.getDni());
			request.getSession().setAttribute("usuario_nombre", usuarioBuscado.getNombre());
			request.getSession().setAttribute("usuario_rol", usuarioBuscado.getRol());
			List<Materia> listarMaterias = servicioMateria.listarMateriasDisponibles();
		
			model.put("listaMaterias",listarMaterias);
			return new ModelAndView("index",model);
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("index", model);
	}
	
	@RequestMapping(path = "/logout")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		
			request.getSession().invalidate();
			return new ModelAndView("redirect:/inicio");
		
	}
}
