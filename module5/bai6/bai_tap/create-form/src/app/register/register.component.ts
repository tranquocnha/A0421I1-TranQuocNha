import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  contactForm = new FormGroup({
    email: new FormControl('',[Validators.email,Validators.required]),
    password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    confirmPassword: new FormControl('',[Validators.required]),
    country: new FormControl('',[Validators.required]),
    age: new FormControl('',[Validators.required,Validators.min(18)]),
    gender: new FormControl('',[Validators.required]),
    phone: new FormControl('',[Validators.required,Validators.pattern(/^\+84 \d{9,10}$/)])
  }, this.pwdMatchValidator);

  constructor() { }

  ngOnInit(): void {
  }

  pwdMatchValidator(frm: FormGroup) {
    if (frm.get('password').value != null && frm.get('confirmPassword').value != null){
      return frm.get('password').value === frm.get('confirmPassword').value
        ? null : {'mismatch': true};
    }
    return null;
  }

  onSubmit() {
    console.log(this.contactForm.value);
  }
}
