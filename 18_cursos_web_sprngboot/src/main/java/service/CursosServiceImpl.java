package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	
	private static ArrayList<Curso> cursos=new ArrayList<>();
	
	@Override
	public boolean nuevo(Curso curso) {
		if(!cursos.stream().anyMatch(c->c.getNombre().equals(curso.getNombre()))) {
			cursos.add(curso);
			return true;
		}
		return false;
	}

	@Override
	public List<Curso> preciosCursoMax(double precioMax) {
		if(cursos==null) {
			return null;
		}
		return cursos.stream().filter(c->c.getPrecio()<precioMax).toList();
	}

	@Override
	public void eliminarCurso(String nombre) {
		cursos.removeIf(c->c.getNombre().equals(nombre));
	}
}
