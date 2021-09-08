package br.com.codeguskr.solosidea.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.codeguskr.solosidea.model.Usuario;

public class UsuarioListDto {
	
	private Long idUsuario;
	private String email;
	private String apelido;
	private String avatar;
	private boolean flgAtivo;
	
	public UsuarioListDto(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.email = usuario.getEmail();
		this.apelido = usuario.getApelido();
		this.avatar = usuario.getAvatar();
		this.flgAtivo = usuario.isFlgAtivo();
	}
	public static List<UsuarioListDto> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioListDto::new).collect(Collectors.toList());
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

	public boolean isFlgAtivo() {
		return flgAtivo;
	}

	public void setFlgAtivo(boolean flgAtivo) {
		this.flgAtivo = flgAtivo;
	}
	
	
	
}
