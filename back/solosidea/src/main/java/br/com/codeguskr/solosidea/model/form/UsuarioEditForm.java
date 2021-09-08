package br.com.codeguskr.solosidea.model.form;

public class UsuarioEditForm {
	
	private String email;
	private String apelido;
	private String avatar;
	private boolean flgAtivo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public boolean isFlgAtivo() {
		return flgAtivo;
	}
	public void setFlgAtivo(boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

}
