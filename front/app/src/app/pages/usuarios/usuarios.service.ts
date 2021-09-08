import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from './Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) { }

  getUsuarios(){
    return this.http.get<Usuario[]>("http://localhost:8080/spotAPIRestUsuario/controller");
  }
  getIdUsuario(usuario: Usuario){
    return this.http.get<Usuario>("http://localhost:8080/spotAPIRestUsuario/controller/"+usuario.idUsuario);
  }
  patchUsuarioHabilitar(usuario: Usuario){
    var body = {flgAtivo : true };
    return this.http.patch<Usuario>("http://localhost:8080/spotAPIRestUsuario/controller/"+usuario.idUsuario, body );
  }
  patchUsuarioDesabilitar(usuario: Usuario){
    var body = {flgAtivo : false };
    return this.http.patch<Usuario>("http://localhost:8080/spotAPIRestUsuario/controller/"+usuario.idUsuario, body );
  }
  deleteUsuario(usuario :Usuario){
    return this.http.delete("http://localhost:8080/spotAPIRestUsuario/controller/"+usuario.idUsuario);
  }
  postUsuario(usuario: any){
    return this.http.post("http://localhost:8080/spotAPIRestUsuario/controller", usuario);
  }
  putUsuario(usuario: any){
    return this.http.put("http://localhost:8080/spotAPIRestUsuario/controller/"+usuario.idUsuario , usuario);
  }
}
