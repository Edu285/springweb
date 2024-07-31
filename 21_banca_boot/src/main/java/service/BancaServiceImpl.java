package service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
import entities.Cuenta;
import entities.Movimiento;
import jakarta.transaction.Transactional;
import model.ClienteDto;
import model.MovimientoDto;
import utilidades.Mapeador;

@Service
public class BancaServiceImpl implements BancaService {

	ClienteDao clienteDao;
	CuentaDao cuentaDao;
	MovimientoDao movimientoDao;
	Mapeador mapeador;
	public BancaServiceImpl(ClienteDao clienteDao, CuentaDao cuentaDao, MovimientoDao movimientoDao,
			Mapeador mapeador) {
		this.clienteDao = clienteDao;
		this.cuentaDao = cuentaDao;
		this.movimientoDao = movimientoDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean validarCuenta(int numeroCuenta) {
		//return cuentaDao.findById(numeroCuenta).isPresent();
		return cuentaDao.existsById(numeroCuenta);
	}	

	@Transactional
	@Override
	public void ingreso(int numeroCuenta, double cantidad) {	
		Cuenta cuenta=cuentaDao.findById(numeroCuenta).orElse(null);
		if(cuenta!=null) {
			cuenta.setSaldo(cuenta.getSaldo()+cantidad);
			operacion(cantidad, "ingreso", cuenta);
		}else {
			throw new RuntimeException(); 
		}
	}

	@Transactional()
	@Override
	public void extraccion(int numeroCuenta, double cantidad) {
		Cuenta cuenta=cuentaDao.findById(numeroCuenta).orElse(null);
		if(cuenta!=null) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			operacion(cantidad,"extraccion", cuenta);
		}else{
			throw new RuntimeException(); 
		}
	}
	
	public void operacion(double cantidad,String operacion,Cuenta cuenta) {
		movimientoDao.save(new Movimiento(0,LocalDateTime.now(), cantidad,
						operacion, cuenta));
		cuentaDao.save(cuenta);
	} 

	@Transactional
	@Override
	public void transferencia(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad) {
		ingreso(numeroCuentaDestino, cantidad);
		extraccion(numeroCuentaOrigen, cantidad);
	}

	@Override
	public List<ClienteDto> titularesCuenta(int numeroCuenta) {
		if(validarCuenta(numeroCuenta)) {
			return clienteDao.findByNumeroCuenta(numeroCuenta).stream()
				.map(c->mapeador.clienteEntityToDto(c))
				.toList();
		}else{
			throw new RuntimeException(); 
		}
	}

	@Override
	public List<MovimientoDto> movimientosCuentaFecha(int numeroCuenta, LocalDateTime fecha) {
		if(validarCuenta(numeroCuenta)) {
			return movimientoDao.findByCuentaFecha(numeroCuenta, fecha).stream()
				.map(m->mapeador.movimientoEntityToDto(m))
				.toList();
		}else{
			throw new RuntimeException(); 
		}
	}
}
