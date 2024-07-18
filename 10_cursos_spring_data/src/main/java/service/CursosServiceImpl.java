package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.CursosDao;
import entities.Curso;
import model.CursoDto;
import utilidades.Mapeador;
@Service
public class CursosServiceImpl implements CursosService {
	
	CursosDao cursosDao;
	Mapeador mapeador;
	
	public CursosServiceImpl(CursosDao cursosDao, Mapeador mapeador) {
		this.cursosDao = cursosDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean nuevo(CursoDto curso) {
		Curso c=mapeador.cursoDtoToEntity(curso);
		if(cursosDao.findByCurso(c.getNombre())==null) {
			cursosDao.save(c);
			return true;
		}
		return false;
	}

	@Override
	public List<CursoDto> preciosCursoMax(double precioMax) {
		//System.out.println("-en el dao"+cursosDao.findByPrecio(precioMax).size());
		return cursosDao.findByPrecio(precioMax).stream()
				.map(c->mapeador.cursoEntityToDto(c))
				.toList(); 
	}

	@Override
	public void eliminarCurso(String nombre) {
		cursosDao.deleteByNombre(nombre);
	}
}
