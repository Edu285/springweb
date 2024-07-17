package dao;

import java.util.List;

import entities.Curso;
//aqui trabajamos con entidades no con el dto
public interface CursosDao {
	List<Curso> findByPrecio(double precio);
	void save(Curso curso);
	void delete(String nombre);
	Curso findByCurso(String nombre);
}
