package service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
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
	public boolean ingreso(int numeroCuenta) {
		if(cuentaDao.findById(numeroCuenta)!=null) {
			return true;
		}
		return false;
	}	

	@Override
	public void ingreso(int numeroCuenta, double cantidad) {	
		if(cuentaDao.findById(numeroCuenta)!=null) {
			
		}
	}

	@Override
	public void extraccion(int numeroCuenta, double cantidad) {
		
	}

	@Override
	public void transferencia(int numeroCuentaOrigen, int numeroCuentaDestino, double cantidad) {
		

	}

	@Transactional
	@Override
	public List<ClienteDto> titularesCuenta(int numeroCuenta) {
		return clienteDao.findAll().stream()
				.map(c->mapeador.clienteEntityToDto(c))
				.toList();
	}

	@Override
	public List<MovimientoDto> movimientosCuentaFecha(int numeroCuenta, LocalDateTime fecha) {
		
	}

}
