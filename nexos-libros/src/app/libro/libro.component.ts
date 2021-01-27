import { Component, OnInit } from '@angular/core';
import { Libro } from './../libro.model';

import { LibrosService } from './../core/services/libros.service';

@Component({
  selector: 'app-libro',
  templateUrl: './libro.component.html',
  styleUrls: ['./libro.component.scss']
})
export class LibroComponent implements OnInit {

  libros: Libro[];
  filtro: Libro[];
  busqueda: string;

  constructor(
    private librosService: LibrosService
  ) { }

  async ngOnInit() {
    await this.fetchLibros();    
  }

  async fetchLibros() {
    this.librosService.getAllLibros()
    .subscribe(libros => {
      this.libros = libros;
      this.filtro = libros;
    });
  }
  

  buscar($evento) {
    this.filtro = this.libros.filter((registro) => registro.titulo.includes($evento) 
    || registro.anio.includes($evento)    
    || registro.autor.nombre.includes($evento)
    || registro.editorial.nombre.includes($evento));    
  }

}

