package com.inventario.main;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inventario.dao.api.TsgUsuarioDaoAPI;
import com.inventario.dao.impl.TsgUsuariosDaoImpl;
import com.inventario.model.TsgUsuarios;

public class MainApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:src/main/resources/config/ApplicationContext.xml");
 		
		TsgUsuarioDaoAPI tsgUsuarioDaoAPI = applicationContext.getBean(TsgUsuariosDaoImpl.class);

		
		TsgUsuarios tsgUsuario1 = new TsgUsuarios();
		tsgUsuario1.setFsgId(4L);
		tsgUsuario1.setFsgLogin("Alex1");
		tsgUsuario1.setFsgNombres("Alexander0");
		tsgUsuario1.setFsgPassword("default0");
		tsgUsuarioDaoAPI.guardar(tsgUsuario1);
		System.out.println(tsgUsuario1);
		
		//mostrar los usuarios almacenados
		System.out.println(tsgUsuarioDaoAPI.getTsgUsuarios());


		//batch
		long start = System.currentTimeMillis();
		List<TsgUsuarios> lista = new ArrayList<TsgUsuarios>();
		for(long i = 1; i <= 10000; i++) {
			TsgUsuarios tsgUsuario = new TsgUsuarios();
			tsgUsuario.setFsgId(i+4);
			tsgUsuario.setFsgLogin("Alex"+i+4);
			tsgUsuario.setFsgNombres("Alexander"+i+4);
			tsgUsuario.setFsgPassword("default"+i+4);
			lista.add(tsgUsuario);
		}
		
		tsgUsuarioDaoAPI.guardar(lista);
		
		long end = System.currentTimeMillis();
		
		System.out.println("Tiempo de duracion " + TimeUnit.MILLISECONDS.toSeconds(end - start));
		
	}  

}
