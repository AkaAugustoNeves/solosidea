package br.com.codeguskr.solosidea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeguskr.solosidea.model.dto.UsuarioDto;
import br.com.codeguskr.solosidea.model.dto.UsuarioListDto;
import br.com.codeguskr.solosidea.model.form.UsuarioEditForm;
import br.com.codeguskr.solosidea.model.form.UsuarioForm;
import br.com.codeguskr.solosidea.model.form.UsuarioHabilitForm;
import br.com.codeguskr.solosidea.service.UsuarioService;

@CrossOrigin("http://localhost:4201")
@RestController
@RequestMapping("/spotAPIRestUsuario/controller")
public class UsuarioController {

	@Autowired
	private UsuarioService us;
	
	@GetMapping
	public ResponseEntity<List<UsuarioListDto>> getUsuarios(){
		return us.findAll();
	}
	
	@GetMapping("/email")
	public ResponseEntity<UsuarioDto> findByEmail (@RequestParam String email){
		System.out.println(email);
		return us.findByEmail(email);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> findById (@PathVariable Long id){
		return us.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioForm form){
		return us.save(form);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById (@PathVariable Long id){
		return us.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDto> edit(@RequestBody UsuarioEditForm form, @PathVariable Long id ){
		return us.editar(form, id);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<UsuarioDto> habilitar(@RequestBody UsuarioHabilitForm form, @PathVariable Long id ){
		return us.habilitar(form, id);
	}
	
}
