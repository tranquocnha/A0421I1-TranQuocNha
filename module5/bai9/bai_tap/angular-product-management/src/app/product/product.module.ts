import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { ProductDeleteComponent } from './product-delete/product-delete.component';
import { ProductCreateComponent } from './product-create/product-create.component';


@NgModule({
  declarations: [
    ProductListComponent,
    ProductEditComponent,
    ProductDeleteComponent,
    ProductCreateComponent
  ],
  imports: [
    CommonModule,
    ProductRoutingModule
  ]
})
export class ProductModule { }
