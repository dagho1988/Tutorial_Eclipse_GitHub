package com.inventario.model;

import java.io.Serializable;

public class TsgUsuarios implements Serializable {

    public Long fsgId;
    public String fsgLogin;
    public String fsgPassword;
    public String fsgNombres;
    
    public TsgUsuarios(){
    }
    
	public TsgUsuarios(Long fsgId, String fsgLogin, String fsgPassword, String fsgNombres) {
		super();
		this.fsgId = fsgId;
		this.fsgLogin = fsgLogin;
		this.fsgPassword = fsgPassword;
		this.fsgNombres = fsgNombres;
	}

	@Override
	public String toString() {
		return "TsgUsuarios [fsgId=" + fsgId + ", fsgLogin=" + fsgLogin + ", fsgPassword=" + fsgPassword
				+ ", fsgNombres=" + fsgNombres + "]";
	}

	public Long getFsgId() {
		return fsgId;
	}

	public void setFsgId(Long fsgId) {
		this.fsgId = fsgId;
	}

	public String getFsgLogin() {
		return fsgLogin;
	}

	public void setFsgLogin(String fsgLogin) {
		this.fsgLogin = fsgLogin;
	}

	public String getFsgPassword() {
		return fsgPassword;
	}

	public void setFsgPassword(String fsgPassword) {
		this.fsgPassword = fsgPassword;
	}

	public String getFsgNombres() {
		return fsgNombres;
	}

	public void setFsgNombres(String fsgNombres) {
		this.fsgNombres = fsgNombres;
	}
    
}
