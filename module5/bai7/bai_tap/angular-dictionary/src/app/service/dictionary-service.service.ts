import { Injectable } from '@angular/core';
import {Iword} from "../iword";


@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {

  words: Iword[] = [
    {word: 'red' , mean: 'màu đỏ'},
    {word: 'blue' , mean: 'màu xanh da trời'},
    {word: 'green' , mean: 'màu xanh lá cây'},
    {word: 'white' , mean: 'màu trắng'},
    {word: 'yellow' , mean: 'màu vàng'},
  ];

  constructor() { }

  findByWord(word: string){
    return this.words.find(item => item.word == word);
  }
}
