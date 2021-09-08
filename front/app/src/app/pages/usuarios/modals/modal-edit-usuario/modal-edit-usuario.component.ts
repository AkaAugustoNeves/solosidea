import { Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Usuario } from '../../Usuario';
import { UsuariosService } from '../../usuarios.service';
import { Edit } from '../Edit';

@Component({
  selector: 'app-modal-edit-usuario',
  templateUrl: './modal-edit-usuario.component.html',
  styleUrls: ['./modal-edit-usuario.component.css']
})
export class ModalEditUsuarioComponent implements OnInit, OnDestroy, OnChanges {

  altPage!: number;
  @Input() exibe!: boolean;
  @Input() tltFormEdit!: String;
  @Input() edit!: Edit;

  @Output() acaoRealizada = new EventEmitter

  formEditUsuario!: FormGroup;

  constructor(private usuarioService: UsuariosService) { }

  ngOnInit(): void {
    this.createEditUsuarioForm(new Usuario);
    this.altPage = document.getElementsByTagName('html')[0].scrollHeight + 60;
  }

  ngOnDestroy(){

  }

  ngOnChanges(){
    if(this.exibe){
        this.createEditUsuarioForm(this.edit.data);  
    }
  }

  createEditUsuarioForm(usuarioForm: Usuario){
    this.formEditUsuario = new FormGroup({
      email: new FormControl(usuarioForm.email),
      apelido: new FormControl(usuarioForm.apelido),
      avatar: new FormControl(usuarioForm.avatar),
      flgAceiteTermo: new FormControl({value: usuarioForm.flgAceiteTermo, disabled: true}),
      flgAceiteLGPD: new FormControl({value: usuarioForm.flgAceiteLGPD, disabled: true}),
      flgAtivo: new FormControl(usuarioForm.flgAtivo)
    })
  }

  onEdit(){
    this.edit.data.email = this.formEditUsuario.value.email;
    this.edit.data.apelido = this.formEditUsuario.value.apelido;
    this.edit.data.avatar = this.formEditUsuario.value.avatar;
    this.edit.data.flgAtivo = this.formEditUsuario.value.flgAtivo;
    this.usuarioService.putUsuario(this.edit.data).subscribe(result=>{
      console.log(result);
      this.fechaBox();
    },err=>{
      console.log(err);
      this.fechaBox();
    })
  }

  fechaBox(){
    this.exibe = false;
    this.acaoRealizada.emit(true);
    this.ngOnDestroy();
    
  }

}
