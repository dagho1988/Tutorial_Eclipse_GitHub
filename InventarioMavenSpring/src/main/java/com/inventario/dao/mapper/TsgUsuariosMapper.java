package com.inventario.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inventario.model.TsgUsuarios;

public class TsgUsuariosMapper implements RowMapper<TsgUsuarios> {

	public TsgUsuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
		TsgUsuarios tsgUsuario = new TsgUsuarios();
		tsgUsuario.setFsgId(rs.getLong("fsg_id"));
		tsgUsuario.setFsgLogin(rs.getString("fsg_login"));
		tsgUsuario.setFsgNombres(rs.getString("fsg_nombres"));
		tsgUsuario.setFsgPassword(rs.getString("fsg_password"));
		return tsgUsuario;
	}

}
