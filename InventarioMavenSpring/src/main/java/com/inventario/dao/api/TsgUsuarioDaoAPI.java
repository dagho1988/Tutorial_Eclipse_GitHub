package com.inventario.dao.api;

import java.util.List;

import com.inventario.model.TsgUsuarios;

public interface TsgUsuarioDaoAPI {

	void guardar(TsgUsuarios tsgUsuario);

	void guardar(List<TsgUsuarios> tsgUsuarios);
	
	List<TsgUsuarios> getTsgUsuarios();
	
}
