package service;

import java.util.List;

import model.CursoDto;

public interface CursosService {
	public boolean nuevo(CursoDto curso);
	public List<CursoDto> preciosCursoMax(double precioMax);
	public void eliminarCurso(String nombre);
}
