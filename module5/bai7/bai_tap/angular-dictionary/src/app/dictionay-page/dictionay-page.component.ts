import { Component, OnInit } from '@angular/core';
import {Iword} from "../iword";
import {DictionaryServiceService} from "../service/dictionary-service.service";

@Component({
  selector: 'app-dictionay-page',
  templateUrl: './dictionay-page.component.html',
  styleUrls: ['./dictionay-page.component.css']
})
export class DictionayPageComponent implements OnInit {

  words: Iword[] = [];

  constructor(private dictionaryServiceService: DictionaryServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.words = this.dictionaryServiceService.words;
  }

}
