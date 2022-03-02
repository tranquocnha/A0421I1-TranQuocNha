import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {

  categoryForm: FormGroup | undefined;
  id: number | undefined;

  constructor(private categoryService: CategoryService,
              private router: Router,
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

  deleteCategory(id: number) {
    this.categoryService.deleteCategory(id).subscribe(() => {
      this.router.navigate(['/category/list']);
    }, (e: any) => {
      console.log(e);
    });
  }

}
