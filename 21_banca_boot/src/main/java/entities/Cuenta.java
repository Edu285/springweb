package entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {
	@Id
	private int numeroCuenta;
	private double saldo;
	@Column(name="tipocuenta")
	private String tipoCuenta;
	@ManyToMany() 
	@JoinTable(name="titulares", joinColumnS=@JoinColumn(name="idCuenta",referencedColumnName="numeroCuenta"),
			inverseJoinColumns = @JoinColumn(name="idCliente",referencedColumnName = "dni"))
	
	@OneToMany(mappedBy = "cuenta")
	private Set<Movimiento> movimientos;
	
	public Cuenta(int numeroCuenta, double saldo, String tipoCuenta, Set<Cliente> clientes,
			Set<Movimiento> movimientos) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
		this.clientes = clientes;
		this.movimientos = movimientos;
	}

	public Cuenta() {
		super();
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
} 