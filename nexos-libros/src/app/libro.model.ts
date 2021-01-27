import { Editorial } from './editorial.model';
import { Autor } from './autor.model';

export interface Libro {
    idLibro: number;
    titulo: string;
    anio: string;
    genero: string;
    numeroPaginas: number;   
    editorial: Editorial; 
    autor: Autor; 
}