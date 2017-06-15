package com.inventario.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inventario.dao.api.TsgUsuarioDaoAPI;
import com.inventario.dao.mapper.TsgUsuariosMapper;
import com.inventario.model.TsgUsuarios;

@Repository
public class TsgUsuariosDaoImpl implements TsgUsuarioDaoAPI {

	private JdbcTemplate jdbcTemplate;
	//para ejecucion de SQL con parametros nombrados
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void guardar(TsgUsuarios tsgUsuario) {
		StringBuilder sql = new StringBuilder(100);
		sql.append("INSERT INTO aplica.tsg_usuarios ");
		sql.append("VALUES (:id, :login, :nombres, :contrasena) ");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", tsgUsuario.getFsgId(), Types.INTEGER);
		params.addValue("login", tsgUsuario.getFsgLogin(), Types.VARCHAR);
		params.addValue("nombres", tsgUsuario.getFsgNombres(), Types.VARCHAR);
		params.addValue("contrasena", tsgUsuario.getFsgPassword(), Types.VARCHAR);
		
		namedParameterJdbcTemplate.update(sql.toString(), params);
		
		
	}

	public List<TsgUsuarios> getTsgUsuarios() {
		StringBuilder sql = new StringBuilder(100);
		sql.append("SELECT * FROM aplica.tsg_usuarios ");
		
		return jdbcTemplate.query(sql.toString(), new TsgUsuariosMapper());
	}

	public void guardar(final List<TsgUsuarios> tsgUsuarios) {
		StringBuilder sql = new StringBuilder(100);
		sql.append("INSERT INTO aplica.tsg_usuarios ");
		sql.append("VALUES (?, ?, ?, ?) ");
		
		jdbcTemplate.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				TsgUsuarios tsgUsuario = tsgUsuarios.get(i);
				ps.setLong(1, tsgUsuario.getFsgId());
				ps.setString(2, tsgUsuario.getFsgLogin());
				ps.setString(3, tsgUsuario.getFsgNombres());
				ps.setString(4, tsgUsuario.getFsgPassword());
			}
			
			public int getBatchSize() {
				return tsgUsuarios.size();
			}
		});
		
	}

}
