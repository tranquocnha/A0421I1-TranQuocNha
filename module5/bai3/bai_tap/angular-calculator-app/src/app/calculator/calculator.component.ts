import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  first = 0;
  second = 0;
  result = 0;


  changFirst(num: number) {
    this.first = Number(num);
  }

  changSecond(num: number) {
    this.second = Number(num);
  }

  calculationResults(calculation: string): void {
    // tslint:disable-next-line:triple-equals
    if (calculation == 'add'){
      this.result = this.first + this.second;
      // tslint:disable-next-line:triple-equals
    }else if (calculation == 'sub'){
      this.result =  this.first - this.second;
      // tslint:disable-next-line:triple-equals
    }else if (calculation == 'mul'){
      this.result =  this.first * this.second;
    }else {
      this.result =  this.first / this.second;
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
