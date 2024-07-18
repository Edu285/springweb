package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import entities.Curso;
//aqui trabajamos con entidades no con el dto

public interface CursosDao extends JpaRepository<Curso,Integer> {
	@Query("select c from Curso c where c.precio<=?1")
	List<Curso> findByPrecio(double precio);
	
	@Transactional
	@Modifying
	void deleteByNombre(String nombre);
	
	Curso findByCurso(String nombre);
}
