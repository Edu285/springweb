package entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno {
	
	@Id
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private int edad;
	@ManyToMany
	@JoinTable(name="matriculas", joinColumns= @JoinColumn(name="usuario",referencedColumnName="usuario"),
			inverseJoinColumns=@JoinColumn(name="idCurso", referencedColumnName="idCurso"))
	private Set<Curso> cursos;
	
	public Alumno(String usuario, String password, String nombre, String email, int edad, Set<Curso> cursos) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.cursos = cursos;
	}

	public Alumno() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
}
