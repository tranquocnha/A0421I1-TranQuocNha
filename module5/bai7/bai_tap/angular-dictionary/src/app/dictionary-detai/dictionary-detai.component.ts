import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../service/dictionary-service.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-dictionary-detai',
  templateUrl: './dictionary-detai.component.html',
  styleUrls: ['./dictionary-detai.component.css']
})
export class DictionaryDetaiComponent implements OnInit {

  word: any;

  constructor(private dictionaryServiceService: DictionaryServiceService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    const key = this.activatedRoute.snapshot.params.word;
    this.word = this.dictionaryServiceService.findByWord(key)
  }

}
