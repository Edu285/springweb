package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Matricula;
import entities.MatriculaPk;

public interface MatriculaDao extends JpaRepository<Matricula, MatriculaPk> {
	//nota media por IdCurso
	@Query("select avg(m.nota) from Matricula m where m.curso.idCurso=?1")
	double avgByIdCurco(int idCurso);
	//nota media por usuario
	@Query("select avg(m.nota) from Matricula m where m.alumno.usuario=?1")
	double avgByUsuario(String usuario);
}
