package entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MatriculaPk implements Serializable{
	private String usuario;
	private int idCurso;
	
	public MatriculaPk(String usuario, int idCurso) {
		super();
		this.usuario = usuario;
		this.idCurso = idCurso;
	}

	public MatriculaPk() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCurso, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaPk other = (MatriculaPk) obj;
		return idCurso == other.idCurso && Objects.equals(usuario, other.usuario);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
}
