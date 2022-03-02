import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  categoryForm: FormGroup | undefined;
  id: number | undefined;

  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // @ts-ignore
      this.id = +paramMap.get('id');
      this.getCategory(this.id);
    });
  }

  ngOnInit() {
  }

  getCategory(id: number) {
    return this.categoryService.findById(id).subscribe((category:any) => {
      this.categoryForm = new FormGroup({
        name: new FormControl(category.name),
      });
    });
  }

  updateCategory(id: number) {
    // @ts-ignore
    const category = this.categoryForm.value;
    this.categoryService.updateCategory(id, category).subscribe(() => {
      alert('Cập nhật thành công');
    }, (e: any) => {
      console.log(e);
    });
  }

}
