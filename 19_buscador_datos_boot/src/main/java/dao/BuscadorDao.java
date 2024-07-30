package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import entities.Resultado;
import jakarta.transaction.Transactional;

public interface BuscadorDao extends JpaRepository<Resultado, Integer>{
	List<Resultado> findByTematica(String tematica);
	
	Resultado findByUrl(String url);
	@Transactional
	@Modifying
	void deleteByUrl(String url);
}
