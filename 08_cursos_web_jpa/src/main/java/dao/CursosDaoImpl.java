package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entities.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
@Repository
public class CursosDaoImpl implements CursosDao{

	@PersistenceContext
	EntityManager eManager;
	
	@Override
	public List<Curso> findByPrecio(double precio) {
		String jpql="select c from Curso c where c.precio<=?1";
		TypedQuery<Curso> query=eManager.createQuery(jpql,Curso.class);
		query.setParameter(1, precio);
		return query.getResultList();
	}

	@Override
	public void save(Curso curso) {
		eManager.persist(curso);
	}

	@Override
	public void delete(String nombre) {
		String jpql="delete from Curso c where c.nombre=?1";
		Query query=eManager.createQuery(jpql);	
		query.setParameter(1,nombre);
		query.executeUpdate();
	}

	@Override
	public Curso findByCurso(String nombre) {
		String jpql="select c from Curso c where c.nombre=:nombre";
		TypedQuery<Curso> query=eManager.createQuery(jpql, Curso.class);
		query.setParameter(1, nombre);
		return query.getSingleResult();
	}

}
