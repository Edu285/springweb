package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.MatriculaDao;
import model.AlumnoDto;
import model.AlumnoMatriculadoDto;
import model.CursoDto;
import utilidades.Mapeador;

@Service
public class FormacionServiceImpl implements FormacionService {

	AlumnosDao alumnosDao;
	CursosDao cursosDao;
	Mapeador mapeador;
	MatriculaDao matriculaDao;
	
	public FormacionServiceImpl(AlumnosDao alumnosDao, CursosDao cursosDao, Mapeador mapeador) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
		this.mapeador = mapeador;
	}
	//esta anotacion se pone para evitar que hibernate cierre la sesion al obtener el
	//y asi no falle cuando se recuperen los objetos relacionados
	@Transactional	
	@Override
	public List<CursoDto> cursos() {
		return cursosDao.findAll().stream()
				.map(c->mapeador.cursoEntityToDto(c))
				.toList();
	}

	@Transactional
	@Override
	public List<AlumnoMatriculadoDto> buscarAlumnosMatriculados(int idCurso) {
		// a partir del curso, obtiene las matriculas y en ellas estan tanto curso como alumno
		return cursosDao.findById(idCurso).get() //Curso
				.getMatriculas().stream() //Stream<Matricula>
				.map(m->new AlumnoMatriculadoDto(mapeador.alumnoEntityToDto(m.getAlumno()),
						mapeador.cursoEntityToDto(m.getCurso()),
						m.getNota()))//Stream<AlumnoMatriculadoDto>
				.toList(); 
	}
	
	@Override
	public boolean registrarCurso(CursoDto curso) {
		if(cursosDao.findByNombreAndFechaInicio(curso.getNombre(), curso.getFechaInicio())==null) {
			cursosDao.save(mapeador.cursoDtoToEntity(curso));
			return true;
		}
		return false;
	}
	@Override
	public double notaMediaCurso(int idCurso) {
		if(cursosDao.findById(idCurso).isPresent()) {
			return matriculaDao.avgByIdCurco(idCurso);
		}
		return 0;
	}
}
