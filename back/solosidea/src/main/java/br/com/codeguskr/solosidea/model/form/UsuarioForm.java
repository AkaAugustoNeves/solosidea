package br.com.codeguskr.solosidea.model.form;

public class UsuarioForm {

	private String email;
	private String senha;
	private String apelido;
	private String avatar;
	private Long idExterno;
	private boolean flgAceiteTermo;
	private boolean flgAceiteLGPD;
	private boolean flgAtivo;
	private String dtHrRegistro;
	
	
	public UsuarioForm() {
		// TODO Auto-generated constructor stub
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
