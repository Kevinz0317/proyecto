/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registro_peliculas;

import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Registro_Peliculas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos met = new Metodos();

        System.out.println(" ===== [ CINE IVONE LOPEZ - KEVIN CHIQUILLO] =====");

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Peliculas");
            System.out.println("2. Clientes");
            System.out.println("3. Peliculas Proximas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int menuPrincipalOption = sc.nextInt();
            sc.nextLine();
            switch (menuPrincipalOption) {
                case 1:
                    gestionarMenuPeliculas(sc, met);
                    break;
                case 2:
                    gestionarMenuClientes(sc, met);
                    break;
                case 3:
                    gestionarMenuPeliculasProximas(sc, met);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void gestionarMenuPeliculas(Scanner sc, Metodos met) {
        while (true) {
            System.out.println("Menu Peliculas:");
            System.out.println("1. Agregar Películas");
            System.out.println("2. Buscar Peliculas por Genero");
            System.out.println("3. Modificar Nombre de la Pelicula");
            System.out.println("4. Mostrar Lista Completa de Peliculas");
            System.out.println("5. Eliminar Peliculas");
            System.out.println("0. Volver al Menu Principal");
            System.out.print("Seleccione una opción: ");

            int op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    met.agregarPelicula();
                    break;
                case 2:
                    System.out.print("Ingrese el genero de películas a buscar: ");
                    String genero = sc.next();
                    met.mostrarPelicula(genero);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la película a modificar: ");
                    String titulo = sc.next();
                    met.modificarPelicula(titulo);
                    break;
                case 4:
                    System.out.println("Lista Completa de Peliculas: ");
                    met.mostrarLista();
                    break;
                case 5:
                    System.out.print("Ingrese el nombre de la pelicula a eliminar: ");
                    String tituloEliminar = sc.next();
                    met.eliminarPelicula(tituloEliminar);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("[Valor incorrecto]");
                    break;
            }
        }
    }

    private static void gestionarMenuClientes(Scanner sc, Metodos met) {
        while (true) {
            System.out.println("Menú Clientes:");
            System.out.println("6. Agregar Cliente");
            System.out.println("7. Hacer Reservacion");
            System.out.println("8. Mostrar Reservaciones de Cliente");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 6:
                    met.agregarCliente();
                    break;
                case 7:
                    met.hacerReservacion();
                    break;
                case 8:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = sc.nextLine();
                    met.mostrarReservacionesCliente(nombreCliente);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("[Valor incorrecto]");
                    break;
            }
        }
    }

    private static void gestionarMenuPeliculasProximas(Scanner sc, Metodos met) {
        while (true) {
            System.out.println("Menu Peliculas Proximas:");
            System.out.println("9. Agregar Pelicula Proxima a Salir");
            System.out.println("10. Mostrar Peliculas Proximas a Salir");
            System.out.println("11. Retirar Proxima Película a Salir");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int op = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea después del número

            switch (op) {
                case 9:
                    System.out.print("Ingrese el titulo de la pelicula proxima a salir: ");
                    String titulo = sc.next();
                    System.out.print("Ingrese el genero de la pelicula proxima a salir: ");
                    String genero = sc.next();
                    Pelicula peliculaProxima = new Pelicula(titulo, genero);
                    met.agregarPeliculaProxima(peliculaProxima);
                    break;
                case 10:
                    System.out.println("Peliculas Próximas a Salir: ");
                    met.mostrarListaPeliculaProxima();
                    break;
                case 11:
                    met.eliminarPeliculaProxima();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("[Valor incorrecto]");
                    break;
            }
        }
    }
}
