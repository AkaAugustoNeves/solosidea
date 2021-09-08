import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { LayoutPartsModule } from '../layout-parts/layout-parts.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsuariosService } from './usuarios/usuarios.service';
import { ModalCreateUsuarioComponent } from './usuarios/modals/modal-create-usuario/modal-create-usuario.component';
import { ModalEditUsuarioComponent } from './usuarios/modals/modal-edit-usuario/modal-edit-usuario.component';



@NgModule({
  declarations: [
    UsuariosComponent,
    ModalCreateUsuarioComponent,
    ModalEditUsuarioComponent
  ],
  imports: [
    CommonModule,
    LayoutPartsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers:[
    UsuariosService
  ]
})
export class PagesModule { }
