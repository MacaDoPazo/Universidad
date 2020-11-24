package ar.edu.dopazo.Universidad.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorInicio {

	@RequestMapping("/inicio")
	public ModelAndView irAInicio()
	{
		return new ModelAndView("index");
	}
	
}
