/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro_peliculas;

import java.util.List;

/**
 *
 * @author kevin
 */
public class Reservacion {
    private Cliente cliente;
    private Pelicula pelicula;
    private String funcion;

    public Reservacion(Cliente cliente, Pelicula pelicula, String funcion) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.funcion = funcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getFuncion() {
        return funcion;
    }
}
