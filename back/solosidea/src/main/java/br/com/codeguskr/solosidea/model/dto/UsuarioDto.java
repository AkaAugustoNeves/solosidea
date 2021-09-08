package br.com.codeguskr.solosidea.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.codeguskr.solosidea.model.Usuario;

public class UsuarioDto {
	
	private Long idUsuario;
	private String email;
	private String apelido;
	private String avatar;
	private boolean flgAceiteTermo;
	private boolean flgAceiteLGPD;
	private boolean flgAtivo;
	private String dtHrRegistro;
	
	public UsuarioDto(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.email = usuario.getEmail();
		this.apelido = usuario.getApelido();
		this.avatar = usuario.getAvatar();
		this.flgAceiteTermo = usuario.isFlgAceiteTermo();
		this.flgAceiteLGPD = usuario.isFlgAceiteLGPD();
		this.flgAtivo = usuario.isFlgAtivo();
		this.dtHrRegistro = usuario.getDtHrRegistro();
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
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
