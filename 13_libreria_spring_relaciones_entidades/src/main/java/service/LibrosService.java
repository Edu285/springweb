package service;

import java.util.List;

import entities.Tema;
import model.LibroDto;
import model.TemaDto;

public interface LibrosService {
	
	boolean guardarLibro(LibroDto libro);

	List<TemaDto> getTemas();

	List<LibroDto> librosTema(int idTema);

	LibroDto getLibro(int isbn);

	TemaDto getTema(int idTema);
	
	TemaDto buscarTemaTituloLibro(String titulo);
}
