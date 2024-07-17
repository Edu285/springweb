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
import model.CursoDto;
import service.CursosService;

@Controller
public class CursosController {
	
	@Autowired
	CursosService service;
	
	@GetMapping(value="buscar")
	public String buscarCurso(@RequestParam("precioMax") double precio, HttpServletRequest request) {
		List<CursoDto> cursos=service.preciosCursoMax(precio);
		request.setAttribute("cursos", cursos);
		return "cursos";
	}
	//para establecer el vinculo bidireccional entre fomulario y el objeto curso	
	@GetMapping(value="formAlta")
	public String prepararAlta(Model model) {
		model.addAttribute("curso", new CursoDto());
		return "nuevo";
	}
	
	@PostMapping(value="alta")
	public String nuevoCurso(@ModelAttribute CursoDto curso) {
		return service.nuevo(curso)?"nuevo":"error";
	}
	
	@PostMapping(value="eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		service.eliminarCurso(nombre);
		return "menu";
	}
}
