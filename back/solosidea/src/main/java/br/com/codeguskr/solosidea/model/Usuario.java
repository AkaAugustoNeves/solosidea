package br.com.codeguskr.solosidea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.codeguskr.solosidea.model.form.UsuarioForm;



@Entity
public class Usuario {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;
	private String email;
	private String senha;
	private String apelido;
	private String avatar;
	private Long idExterno;
	private boolean flgAceiteTermo;
	private boolean flgAceiteLGPD;
	private boolean flgAtivo;
	private String dtHrRegistro;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(UsuarioForm form) {
		this.email = form.getEmail();
		this.senha = form.getSenha();
		this.apelido = form.getApelido();
		this.avatar = form.getAvatar();
		this.idExterno = form.getIdExterno();
		this.flgAceiteTermo = form.isFlgAceiteTermo();
		this.flgAceiteLGPD = form.isFlgAceiteLGPD();
		this.flgAtivo = form.isFlgAtivo();
		this.dtHrRegistro = form.getDtHrRegistro();
		
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Long getIdExterno() {
		return idExterno;
	}
	public void setIdExterno(Long idExterno) {
		this.idExterno = idExterno;
	}
	public boolean isFlgAceiteTermo() {
		return flgAceiteTermo;
	}
	public void setFlgAceiteTermo(boolean flgAceiteTermo) {
		this.flgAceiteTermo = flgAceiteTermo;
	}
	public boolean isFlgAceiteLGPD() {
		return flgAceiteLGPD;
	}
	public void setFlgAceiteLGPD(boolean flgAceiteLGPD) {
		this.flgAceiteLGPD = flgAceiteLGPD;
	}
	public boolean isFlgAtivo() {
		return flgAtivo;
	}
	public void setFlgAtivo(boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}
	public String getDtHrRegistro() {
		return dtHrRegistro;
	}
	public void setDtHrRegistro(String dtHrRegistro) {
		this.dtHrRegistro = dtHrRegistro;
	}
	
}
