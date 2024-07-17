package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.Curso;
import service.CursosService;

@Controller
public class CursosController {
	
	/*@Autowired
	CursosService service;*/
	//con constructor mucho mejor para hacer pruebas
	CursosService service;
	public CursosController(CursosService service) {
		this.service = service;
	}
		
	@GetMapping(value="buscar")
	public String buscarCurso(@RequestParam("precio") double precio, HttpServletRequest request) {
		List<Curso> cursos=service.preciosCursoMax(precio);
		request.setAttribute("cursos", cursos);
		return "cursos";
	}
	//para establecer el vinculo bidireccional entre fomulario y el objeto curso	
	@GetMapping(value="formAlta")
	public String prepararAlta(Model model) {
		model.addAttribute("curso", new Curso());
		return "nuevo";
	}
	
	@PostMapping(value="alta")
	public String nuevoCurso(@ModelAttribute Curso curso) {
		return service.nuevo(curso)?"nuevo":"error";
	}
	
	@PostMapping(value="eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		service.eliminarCurso(nombre);
		return "menu";
	}
}
