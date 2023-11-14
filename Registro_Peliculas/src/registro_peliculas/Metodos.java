/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro_peliculas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Metodos {

    private List<Pelicula> ListaPelicula = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private Stack<Pelicula> ListaPeliculaProxima = new Stack<>();

    public Metodos() {
    }

    public void agregar(Pelicula pelicula) {
        ListaPelicula.add(pelicula);
    }

    public void agregarPelicula() {
        Scanner sc = new Scanner(System.in);
        System.out.println("REGISTRO DE PELICULA");
        System.out.print("- Nombre de la Pelicula: ");
        String titulo = sc.nextLine();
        System.out.print("- Genero de la pelicula: ");
        String genero = sc.nextLine();
        Pelicula pelicula = new Pelicula(titulo, genero);
        ListaPelicula.add(pelicula);
        System.out.println("[ Pelicula agregada exitosamente ]");
    }

    public void mostrarLista() {
        int i = 1;
        for (Pelicula pelicula : ListaPelicula) {
            System.out.println("Pelicula #" + i + ":");
            System.out.println("- Titulo: " + pelicula.getTitulo());
            System.out.println("- Genero: " + pelicula.getGenero());
            System.out.println("");
            i++;
        }
    }

    public void mostrarPelicula(String genero) {
        boolean mostrar = false;
        System.out.println("Pelicula(s) con genero " + genero + ":");
        for (Pelicula pelicula : ListaPelicula) {
            if (pelicula.getGenero().equalsIgnoreCase(genero)) {
                mostrar = true;
                System.out.println("- Titulo: " + pelicula.getTitulo());
                System.out.println("- Genero: " + pelicula.getGenero());
                System.out.println("");
            }
        }

        if (!mostrar) {
            System.out.println("[ No se encontraron peliculas con el genero " + genero + " ]");
        }
    }

    public void modificarPelicula(String titulo) {
        Scanner sc = new Scanner(System.in);
        boolean modificar = false;

        for (Pelicula pelicula : ListaPelicula) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                modificar = true;
                System.out.println("Modificar el nombre de la Pelicula " + titulo + ":");
                System.out.print("- Nuevo Nombre: ");
                String tit = sc.nextLine();
                pelicula.setTitulo(tit);
                System.out.println("[ El nombre de la película se modifico correctamente ]");
            }
        }

        if (!modificar) {
            System.out.println("[ La pelicula " + titulo + " no se encuentra en el inventario ]");
        }
    }

    public void eliminarPelicula(String titulo) {
        Iterator<Pelicula> iterator = ListaPelicula.iterator();
        while (iterator.hasNext()) {
            Pelicula pelicula = iterator.next();
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                iterator.remove(); // Elimina la película de la lista
                System.out.println("[ La película " + titulo + " ha sido eliminada ]");
                return; // Salir del bucle una vez que se ha eliminado la película
            }
        }
        System.out.println("[ La película " + titulo + " no se encuentra en el inventario ]");
    }

    public void agregarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el email del cliente: ");
        String email = sc.nextLine();
        System.out.print("Ingrese el documento del cliente: ");
        int documento = sc.nextInt();
        System.out.print("Ingrese la edad del cliente: ");
        int edad = sc.nextInt();
        Cliente cliente = new Cliente(nombre, email, documento, edad);
        listaClientes.add(cliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    public void hacerReservacion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente que desea hacer la reservación: ");
        String nombreCliente = sc.nextLine();
        Cliente cliente = buscarClientePorNombre(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el título de la película para la reservación: ");
        String tituloPelicula = sc.nextLine();
        Pelicula pelicula = buscarPeliculaPorTitulo(tituloPelicula);

        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        System.out.print("Ingrese la función: ");
        String funcion = sc.nextLine();
        System.out.print("Ingrese los asientos reservados (separados por comas): ");
        String asientosStr = sc.nextLine();
        String[] asientosReservados = asientosStr.split(",");

        Reservacion reservacion = new Reservacion(cliente, pelicula, funcion);
        cliente.agregarReservacion(reservacion);
        System.out.println("Reservación realizada exitosamente.");
    }

    public void mostrarReservacionesCliente(String nombreCliente) {
        Cliente cliente = buscarClientePorNombre(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Reservaciones de " + nombreCliente + ":");
        for (Reservacion reservacion : cliente.getReservaciones()) {
            System.out.println("Película: " + reservacion.getPelicula().getTitulo());
            System.out.println("Función: " + reservacion.getFuncion());
            System.out.println();
        }
    }

    private Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }
    
    private Pelicula buscarPeliculaPorTitulo(String titulo) {
    for (Pelicula pelicula : ListaPelicula) {
        if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
            return pelicula;
        }
    }
    return null; 
}
   public void agregarPeliculaProxima(Pelicula pelicula) {
        ListaPeliculaProxima.push(pelicula); // Agregar a la Stack de películas próximas
    }

    public void mostrarListaPeliculaProxima() {
        Stack<Pelicula> tempStack = new Stack<>();
        while (!ListaPeliculaProxima.isEmpty()) {
            Pelicula pelicula = ListaPeliculaProxima.pop();
            System.out.println("Titulo: " + pelicula.getTitulo());
            System.out.println("Género: " + pelicula.getGenero());
            System.out.println();
            tempStack.push(pelicula);
        }
        while (!tempStack.isEmpty()) {
            ListaPeliculaProxima.push(tempStack.pop());
        }
    }
    
    public void eliminarPeliculaProxima() {
        if (!ListaPeliculaProxima.isEmpty()) {
            ListaPeliculaProxima.pop(); // Eliminar la última película de la pila
            System.out.println("[ Película próxima a salir eliminada exitosamente ]");
        } else {
            System.out.println("[ No hay películas próximas a salir para eliminar ]");
        }
    }

}
