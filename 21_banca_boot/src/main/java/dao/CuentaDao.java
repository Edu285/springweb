package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, Integer> {
	//vienen heredados para la funcionalidad de Cuentas
}
