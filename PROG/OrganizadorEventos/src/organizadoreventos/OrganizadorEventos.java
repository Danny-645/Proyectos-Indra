package organizadoreventos;
import java.util.Scanner;
import modelo.newpackage.GestionEventos;
import static modelo.newpackage.GestionEventos.Fecha;
import static modelo.newpackage.GestionEventos.limpiarPantalla;

/**
 *
 * @author Dan645
 */

public class OrganizadorEventos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("******* Gestion de Eventos *******");
            System.out.println("*       1. Agregar evento        *");
            System.out.println("*       2. Mostrar eventos       *");
            System.out.println("*       3. Buscar evento         *");
            System.out.println("*       4. Eliminar evento       *");
            System.out.println("*       5. Salir                 *");
            System.out.println("**********************************");

            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();
            
            limpiarPantalla();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Ingrese el nombre del evento: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese la fecha del evento (**/**/****): ");
                    String fecha = scanner.nextLine();
                    
                    while (true) {
                        System.out.print("Ingrese la fecha del evento (**/**/****): ");
                        fecha = scanner.nextLine();
                        if (Fecha(fecha)) {
                            break;
                        } else {
                            System.out.println("Formato de fecha incorrecto, intentalo de nuevo.");
                        }
                    }

                    System.out.print("Ingrese una descripcion para el evento: ");
                    String descripcion = scanner.nextLine();

                    GestionEventos.agregarEvento(nombre, fecha, descripcion);
                }

                case "2" -> GestionEventos.mostrarEventos();

                case "3" -> {
                    System.out.print("Ingrese el nombre del evento a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    GestionEventos.buscarEvento(nombreBuscar);
                }

                case "4" -> {
                    System.out.print("Ingrese el nombre del evento a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    GestionEventos.eliminarEvento(nombreEliminar);
                }

                case "5" -> {
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opción no valida, intentalo de nuevo.");
            }
        }
    }
}
