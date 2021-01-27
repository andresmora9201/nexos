import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Libro } from './../../libro.model';

@Injectable({
  providedIn: 'root'
})
export class LibrosService {

  constructor(
    private http: HttpClient
  ) { }

  getAllLibros() {
    return this.http.get<Libro[]>('http://localhost:8888/v1/libros/');
  }
}
