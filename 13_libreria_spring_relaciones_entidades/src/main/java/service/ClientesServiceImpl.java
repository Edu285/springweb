package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.VentasDao;
import entities.Cliente;
import model.ClienteDto;
import model.VentaDto;
import utilidades.Mapeador;
@Service
public class ClientesServiceImpl implements ClientesService {

	ClientesDao clientesDao;
	VentasDao ventasDao;
	Mapeador mapeador;
	
	public ClientesServiceImpl(ClientesDao clientesDao, Mapeador mapeador, VentasDao ventasDao) {
		this.clientesDao = clientesDao;
		this.mapeador = mapeador;
		this.ventasDao= ventasDao;
	}

	@Override
	public boolean autenticar(String usuario, String password) {
		Cliente cliente=clientesDao.findByUsuario(usuario);
		return cliente!=null&&cliente.getPassword().equals(password);
	}

	@Override
	public boolean registrar(ClienteDto cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;
	}
	
	@Override
	public List<VentaDto> ventasCliente(String usuario) {
		return ventasDao.findByBuyByUsuario(usuario).stream()
				.map(v->mapeador.ventaEntitytoDto(v)).toList();
	}
}
