package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Tema;

public interface TemasDao extends JpaRepository<Tema, Integer> {
	//vienen heredados nos ahorramos en este caso el codigo
}
