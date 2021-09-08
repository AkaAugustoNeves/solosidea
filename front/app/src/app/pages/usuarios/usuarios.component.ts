import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Edit } from './modals/Edit';
import { Usuario } from './Usuario';
import { UsuariosService } from './usuarios.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  
  exibeCreateForm: boolean = false;
  tltFormEdit: String = "";

  exibeEditForm: boolean = false;
  edit: Edit = new Edit;

  formUsuario!: FormGroup;
  usuarios : Usuario[] = [];

  constructor(private usuarioService: UsuariosService) { }

  ngOnInit(): void {
    this.buscarTodos();
  }

  acaoEditModal(event: any){
    if(event){
      this.exibeEditForm = false;
    }
    this.ngOnInit();
  }

  acaoCreateModal(event: any){
    if(event){
      this.exibeCreateForm = false;
    }
    this.ngOnInit();
  }

  novo(){
    this.tltFormEdit = "Criar Usuário";
    this.exibeCreateForm =true;
  }

  async buscarTodos(){
    this.usuarioService.getUsuarios().subscribe(result=>{
      console.log(result);
      this.usuarios = result;
    },err=>{
      console.log(err)
    })
  }

  editar(usuario: Usuario){
    this.usuarioService.getIdUsuario(usuario).subscribe(result=>{
      console.log(result)
      this.edit.data = result;
      this.edit.isPresent = true;
      this.edit.classe = "usuario";
      this.tltFormEdit = "Editar Usuário";
      this.exibeEditForm = true;
    },err=>{
      console.log(err);
    })
    
  }

  desabilitar(usuario: Usuario){
    this.usuarioService.patchUsuarioDesabilitar(usuario).subscribe(result=>{
      console.log(result)
      this.ngOnInit()
    },err=>{
      console.log(err)
    })  
  }

  habilitar(usuario: Usuario){
    this.usuarioService.patchUsuarioHabilitar(usuario).subscribe(result=>{
      console.log(result)
      this.ngOnInit()
    },err=>{
      console.log(err)
    }) 
  }

  excluir(usuario: Usuario){
    this.usuarioService.deleteUsuario(usuario).subscribe(result=>{
      console.log(result)
      this.ngOnInit()
    },err=>{
      console.log(err)
    })
  }

}
