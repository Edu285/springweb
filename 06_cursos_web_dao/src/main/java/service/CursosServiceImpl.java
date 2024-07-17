package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CursosDao;
import model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	CursosDao dao;
	
	@Override
	public boolean nuevo(Curso curso) {
		if(dao.findByCurso(curso.getNombre())==null) {
			dao.save(curso);
			return true;
		}
		return false;
	}

	@Override
	public List<Curso> preciosCursoMax(double precio) {
		if(dao.findByMaxPrice(precio)==null) {
			return null;
		}
		return dao.findByMaxPrice(precio);
	}

	@Override
	public void eliminarCurso(String nombre) {
		dao.delete(nombre);
	}
}
