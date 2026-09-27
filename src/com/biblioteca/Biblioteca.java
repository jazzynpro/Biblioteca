package com.biblioteca;

import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Libro> libros;
	
	//Constructor vacio
	public Biblioteca() {
		this.libros = new ArrayList<Libro>(); 
	}
	public Biblioteca(ArrayList<Libro> libros) {
	this.libros = libros;
	
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	//Metodo agregar libro
	public void agregarLibro(Libro libro) {
		libros.add(libro);
	}
	//Metodo eliminarLibro
	public void eliminarLibro(Libro libro) {
		int indice = obtenerIndice(libro);
		if (indice == -1) {
			System.out.println("No existe registro para eliminar");
			//return se usa para indicar al metodo el fin de su ejecucion
			return ;
		}
		libros.remove(indice);
	}
	//eliminar libro por indice
	public Libro eliminarLibro(int indice) {
		Libro libro = null;
		if (indice <0 || indice >= libros.size()) {
			System.out.println("Indice no es correcto");
			//Return se usa para indicar al metodo el fin de su ejecucion
			return libro;
		}
		libro = libros.get(indice);
		libros.remove(indice);
		return libro;
	}
	
	//Metodo obtenerIndice
	public int obtenerIndice(Libro libro) {
		int indice = -1 ;
		
		if(libro == null) {
			
			return indice;
		}
		for(int i= 0; i<libros.size(); i++) {
			if(libros.get(i).getId() == libro.getId()) {
				indice = i;
				//rompe el for ya no recorre el arreglo lista
				break;
			}
		}
		
		return 0;
	}
	
	
	
	//Metodo prestar libro
	public void prestarLibro(Libro libro, Usuario usuario) {
		
		if(usuario.getLibrosPrestados().size()>3) {
			System.out.println("NO PUEDES PEDIR MAS DE 3");
			return;
		}
		
		for(int i = 0; i<libros.size(); i++) {
			
			if(libros.get(i).getId()==libro.getId()) {
				if(libros.get(i).isPrestado()) {
					System.out.println("Lo sentimos no se puede prestar");
					return;
				}
				libros.get(i).prestar();
				usuario.tomarLibro(libro);
			}
		}
	}
	//Metodo buscar por ID
	public Libro buscarPorId(int id) {
		for(Libro libro : libros) {
		if(libro.getId()== id) {
			return libro;
		}
	}
		return null;
	}
	//Metodo buscar por titulo
	public Libro buscarPorTitulo(String titulo) { //metodo tipo libro indica que recibimos un dato y devolvemos 1 unico objeto
		for(Libro libro : libros) {
			if(libro.getTitulo().equalsIgnoreCase(titulo)) { 
				return libro;
			}
		}return null;
	}
	//Metodo mostrar libros 
	public void mostrarLibrosDisponibles() {
		for(Libro libro : libros) {
			if(!libro.isPrestado()) {
				System.out.println(libro);
			}else {
				System.out.println("Libro no disponible");
			}
		}
	}
	
	//Metodo buscar por autor
	public void buscarPorAutor(String nombreAutor) {   		//aqui se usa el void porque queremos una respuesta general no algo especifico
		boolean encontrado = false;
		for(Libro libro : libros) {
			if(libro.getAutor().equalsIgnoreCase(nombreAutor)) {
				System.out.println(libro);
				encontrado = true;
			}
		}if(!encontrado) {
			System.out.println("No se encontraron libros de este AUTOR");
		}
	}
	//Metodo buscar por precio MAXIMO
	public void buscarPrecioMaximo(double precioMaximo) {
		boolean encontrado = false;
		for(Libro libro : libros) {
			if(libro.getPrecio() <= precioMaximo) {
				System.out.println(libro);
				encontrado = true;
			}
		}if(!encontrado) {
			System.out.println("No se encontraron libros dentro de ese precio");
		}
	}
	
	//Metodo buscar por precio MINIMO
	public void buscarPrecioMinimo(double precioMinimo) {
		boolean encontrado = false;
		for(Libro libro : libros) {
			if(libro.getPrecio() >= precioMinimo) {
				System.out.println(libro);
				encontrado = true;
			}if(!encontrado) {
				System.out.println("No se encontraron libros menores al precio deseado");
			}
		}
		
	}
	
	//Metodo para buscar coincidencias 
	public ArrayList<Libro> buscarPorCadena(String cadena){ 
		ArrayList<Libro>lista = new ArrayList<Libro>(); //inicializamos la lista para que no nos de un null pointer 
		for(Libro libro: libros) {
			if(libro.getAutor().contains(cadena)) { //contais indica que va a entrar al if todo lo que coincida con la cadena
			//llenar la lista
				lista.add(libro);
				System.out.println(libro);
			}
		}//fuera del for tenemos que poner la validacion que no se encontro nada
		
		//if(lista.size()== 0) 
		if(lista.isEmpty()){
			System.out.println("No hay resultados");
		}
		
		return lista;
	}
	
	
	
	
	}
