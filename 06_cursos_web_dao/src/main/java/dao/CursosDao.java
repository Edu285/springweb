package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {
	public void save(Curso curso);
	public List<Curso> findByMaxPrice(double precio);
	public void delete(String nombre);
	public Curso findByCurso(String nombre);
	public double averageByTematica(String tematica);
}
