import { Injectable } from '@angular/core';
import { Regiao } from '../model/regiao';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor() { }

  listRegiao(): Regiao[]{
    return [
      {id: 1, regiao: 'Nordeste', total: 1452}
    ];
  }
}
