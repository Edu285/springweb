package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class CursosDaoImpl implements CursosDao {

	/*@Autowired //esta mal visto 
	JdbcTemplate template;*/
	//mejor asi generando un constructor
	JdbcTemplate template;
	public CursosDaoImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void save(Curso curso) {
		String sql="select into cursos (nombre,tematica,duracion,precio) values=(?,?,?,?)";
		template.update(sql,curso.getNombre(),curso.getTematica(),curso.getDuracion(),curso.getPrecio());	
	}

	@Override
	public List<Curso> findByMaxPrice(double precio) {
		String sql="select * from cursos where precio<=?";
		RowMapper<Curso> mapper=(r,f)->new Curso(
				r.getString("nombre"),
				r.getString("tematica"),
				r.getInt("duracion"),
				r.getDouble("precio"));
		return template.query(sql,mapper,precio);
	}

	@Override
	public void delete(String nombre) {
		template.update("delete from cursos where nombre=?", nombre); 
	}

	@Override
	public Curso findByCurso(String nombre) {
		String sql="select * from cursos where nombre=?";
		/*RowMapper<Curso> mapper=(r,f)->new Curso(
				r.getString("nombre"),
				r.getString("tematica"),
				r.getInt("duracion"),
				r.getDouble("precio"));
		List<Curso> cursos= template.query(sql,mapper,nombre);
		return cursos.size()>0?cursos.get(0):null;*/
		//version alternativa
		try{
			return template.queryForObject(sql,(r,f)->new Curso(
					r.getString("nombre"),
					r.getString("tematica"),
					r.getInt("duracion"),
					r.getDouble("precio")),nombre);
		}catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public double averageByTematica(String tematica) {
		String sql="select avg(precio) from cursos where tematica=?";
		return template.queryForObject(sql, Double.class,tematica);
	}
	
}
