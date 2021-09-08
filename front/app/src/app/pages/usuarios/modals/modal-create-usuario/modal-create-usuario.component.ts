import { Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Usuario } from '../../Usuario';
import { UsuariosService } from '../../usuarios.service';
import { Edit } from '../Edit';

@Component({
  selector: 'app-modal-create-usuario',
  templateUrl: './modal-create-usuario.component.html',
  styleUrls: ['./modal-create-usuario.component.css']
})
export class ModalCreateUsuarioComponent implements OnInit, OnDestroy, OnChanges {

  altPage!: number;
  @Input() exibe!: boolean;
  @Input() tltFormEdit!: String;

  @Output() acaoRealizada = new EventEmitter

  formCreateUsuario!: FormGroup;

  constructor(private usuarioService: UsuariosService) { }

  ngOnInit(): void {
    this.createUsuarioForm();
    this.altPage = document.getElementsByTagName('html')[0].scrollHeight + 60;
  }

  ngOnDestroy(){

  }

  ngOnChanges(){
    if(this.exibe){
      this.createUsuarioForm();  
    }
  }

  createUsuarioForm(){
    this.formCreateUsuario = new FormGroup({
      email: new FormControl(""),
      senha: new FormControl(""),
      apelido: new FormControl(""),
      avatar: new FormControl(""),
      flgAceiteTermo: new FormControl(false),
      flgAceiteLGPD: new FormControl(false),
      flgAtivo: new FormControl(false),
      dtHrRegistro: new FormControl()
    })
  }

  createUsuario(){
    this.formCreateUsuario.value.dtHrRegistro = Date.now().toString();
     this.usuarioService.postUsuario(this.formCreateUsuario.value).subscribe(result=>{
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
