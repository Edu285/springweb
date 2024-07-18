package model;

public class CursoDto {
	private int codCurso;
	private String nombre;
	private String tematica;
	private int duracion;
	private double precio;
	public CursoDto(int codCurso, String nombre,String tematica, int duracion, double precio) {
		super();
		this.setCodCurso(codCurso);
		this.nombre = nombre;
		this.tematica = tematica;
		this.duracion = duracion;
		this.precio = precio;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public CursoDto() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
}
