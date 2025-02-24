package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer>{
	List<Libro> findByIdTema(int idTema);
	//el resto son heredados
	List<Libro> findByPrecioBetween(double pMin, double pMax);
}
