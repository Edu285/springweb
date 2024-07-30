package service;

import java.util.List;

import model.Curso;

public interface CursosService {
	public boolean nuevo(Curso curso);
	public List<Curso> preciosCursoMax(double precioMax);
	public void eliminarCurso(String nombre);
}
