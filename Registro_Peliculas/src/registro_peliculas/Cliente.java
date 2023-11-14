/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro_peliculas;

/**
 *
 * @author kevin
 */
import java.util.Queue;
import java.util.LinkedList;

public class Cliente {
    private String nombre;
    private String email;
    private int documento;
    private int edad;
    private Queue<Reservacion> reservaciones;

    public Cliente(String nombre, String email, int documento, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.documento = documento;
        this.edad = edad;
        this.reservaciones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public Queue<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void agregarReservacion(Reservacion reservacion) {
        reservaciones.offer(reservacion); 
    }

    public Reservacion obtenerProximaReservacion() {
        return reservaciones.poll();
    }

    public void mostrarReservaciones() {
        System.out.println("Reservaciones de " + nombre + ":");
        for (Reservacion reservacion : reservaciones) {
            System.out.println("Película: " + reservacion.getPelicula().getTitulo());
            System.out.println("Función: " + reservacion.getFuncion());
            System.out.println();
        }
    }
}