package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import entities.Libro;
import model.LibroDto;
import model.TemaDto;
import utilidades.Mapeador;
@Service
public class LibrosServiceImpl implements LibrosService {

	TemasDao temasDao;
	LibrosDao librosDao;
	Mapeador mapeador;

	public LibrosServiceImpl(TemasDao temasDao, LibrosDao librosDao, Mapeador mapeador) {
		super();
		this.temasDao = temasDao;
		this.librosDao = librosDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean guardarLibro(LibroDto libro) {
		Optional <Libro> opLibro=librosDao.findById(libro.getIsbn());
		if(librosDao.findById(libro.getIsbn()) != null){
			return false;
		}
		librosDao.save(mapeador.libroDtoToEntity(libro));
		return true;
	}

	@Override
	public List<TemaDto> getTemas() {
		return temasDao.findAll().stream()
				.map(t->Mapeador.temaEntityToDto(t))//Stream<TemaDto>
				.toList();
	}

	@Override
	public List<LibroDto> librosTema(int idTema) {
		if(idTema!=0) {
			return librosDao.findByIdTema(idTema).stream()
					.map(l->Mapeador.libroEntityToDto(l))
					.toList();
		}else{
			return librosDao.findAll().stream()
					.map(l->Mapeador.libroEntityToDto(l))
					.toList();
		}
		
	}

	@Override
	public LibroDto getLibro(int isbn) {
		Optional<Libro> opLibro=librosDao.findById(isbn);
		return mapeador.libroEntityToDto(opLibro.isPresent()?opLibro.get():new Libro());
	}

	@Override
	public TemaDto getTema(int idTema) {
		
	}

}
