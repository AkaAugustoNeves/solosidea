package br.com.codeguskr.solosidea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.codeguskr.solosidea.model.Usuario;
import br.com.codeguskr.solosidea.model.dto.UsuarioDto;
import br.com.codeguskr.solosidea.model.dto.UsuarioListDto;
import br.com.codeguskr.solosidea.model.form.UsuarioEditForm;
import br.com.codeguskr.solosidea.model.form.UsuarioForm;
import br.com.codeguskr.solosidea.model.form.UsuarioHabilitForm;
import br.com.codeguskr.solosidea.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository ur;

	public ResponseEntity<List<UsuarioListDto>> findAll() {
		return ResponseEntity.ok(UsuarioListDto.converter(ur.findAll()));
	}
	
	public ResponseEntity<UsuarioDto> findByEmail(String email) {
		Optional<Usuario> usuario = ur.findByEmail(email);
		if (usuario.isPresent()) {
			return ResponseEntity.ok().body(new UsuarioDto(usuario.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<UsuarioDto> findById(Long id){
		Optional<Usuario> usuario = ur.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok().body(new UsuarioDto(usuario.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<UsuarioDto> save(UsuarioForm form){
		return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDto(ur.save(new Usuario(form))));
	}
	
	public ResponseEntity<?> delete(Long id){
		Optional<Usuario> usuario = ur.findById(id);
		if (usuario.isPresent()) {
			ur.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<UsuarioDto> editar(UsuarioEditForm form, Long id){
		Optional<Usuario> usuario = ur.findById(id);
		usuario.get().setApelido(form.getApelido());
		usuario.get().setAvatar(form.getAvatar());
		usuario.get().setEmail(form.getEmail());
		usuario.get().setFlgAtivo(form.isFlgAtivo());
		return ResponseEntity.ok().body(new UsuarioDto(ur.save(usuario.get())));		
	}
	
	public ResponseEntity<UsuarioDto> habilitar(UsuarioHabilitForm form, Long id){
		Optional<Usuario> usuario = ur.findById(id);
		usuario.get().setFlgAtivo(form.isFlgAtivo());
		return ResponseEntity.ok().body(new UsuarioDto(ur.save(usuario.get())));
	}
	
	
}
