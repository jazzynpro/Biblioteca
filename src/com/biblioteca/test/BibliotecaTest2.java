package com.biblioteca.test;

import java.util.ArrayList;

import com.biblioteca.Biblioteca;
import com.biblioteca.Libro;

public class BibliotecaTest2 {

	public static void main(String[] args) {
		Libro l1 = new Libro(1,"JJ benitez", "Caballo de troya","Misterio", 2010, 21.00);
		Libro l2 = new Libro(2,"Gabriel Garcia Marquez", "Caballo de troya","Misterio", 2010, 21.00);
		Libro l3 = new Libro(3,"Maria Fernanda Heredia", "Caballo de troya","Aventura", 2010, 21.00);
		Libro l4 = new Libro(4,"Homero","Policial", "Caballo de troya", 2010, 21.00);
		Libro l5 = new Libro(5,"Benitez","Romance", "Caballo de troya", 2010, 21.00);
		
		Biblioteca b1 = new Biblioteca();
		b1.agregarLibro(l1);
		b1.agregarLibro(l2);
		b1.agregarLibro(l3);
		b1.agregarLibro(l4);
		b1.agregarLibro(l5);
		
		System.out.println("libros: " + b1.getLibros());
		ArrayList<Libro> libros = b1.buscarPorCadena("ghj");
		System.out.println("Libros encontrados: " + libros);
		
		System.out.println();	
		System.out.println("Eliminar registro: ");
		System.out.println("Cantidad libros: " + b1.getLibros().size());
		
		//b1.eliminarLibro(l5);
		//b1.eliminarLibro(l4);
		
			
		//b1.eliminarLibro(new Libro());
		//System.out.println("Cantidad libros con new Libro: " + b1.getLibros().size());
		
		b1.eliminarLibro(null);
		System.out.println("Cantidad libros con null: " + b1.getLibros().size());
		//con indice
		Libro libro= b1.eliminarLibro(2);
		System.out.println("Cantidad libros con indice: " + b1.getLibros().size());
		System.out.println("libro eliminado: " + libro);
	}

}
