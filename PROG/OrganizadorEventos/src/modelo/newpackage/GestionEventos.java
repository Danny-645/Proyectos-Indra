package modelo.newpackage;

/**
 *
 * @author Dan645
 */
public class GestionEventos {

    // Constantes para el tamaño máximo de eventos
    public static int MAX_EVENTOS = 150;
    public static String[] nombres = new String[MAX_EVENTOS];
    public static String[] fechas = new String[MAX_EVENTOS];
    public static String[] descripciones = new String[MAX_EVENTOS];
    public static int totalEventos = 0; // Contador de eventos registrados

    // Método para agregar un evento
    public static void agregarEvento(String nombre, String fecha, String descripcion) {
        if (totalEventos >= MAX_EVENTOS) {
            System.out.println("¡Limite alcanzado! No se pueden agregar mas eventos.");
            return;
        }

        nombres[totalEventos] = nombre;
        fechas[totalEventos] = fecha;
        descripciones[totalEventos] = descripcion;

        totalEventos++; // Incrementa el contador de eventos al añadir un evento
        System.out.println("Un nuevo evento ha sido agregado.");
    }

    // Método para mostrar todos los eventos creados
    public static void mostrarEventos() {
        if (totalEventos == 0) {
            System.out.println("No hay eventos registrados.");
        } else {
            System.out.println("Lista de eventos:");
            for (int i = 0; i < totalEventos; i++) {
                System.out.println((i + 1) + ". Nombre: " + nombres[i]);
                System.out.println("   Fecha: " + fechas[i]);
                System.out.println("   Descripcion: " + descripciones[i] + "\n");
            }
        }
    }

    // Método para buscar un evento según su nombre exacto
    public static void buscarEvento(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < totalEventos; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                System.out.println("Evento encontrado:");
                System.out.println("Nombre: " + nombres[i]);
                System.out.println("Fecha: " + fechas[i]);
                System.out.println("Descripcion: " + descripciones[i] + "\n");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Evento no encontrado.");
        }
    }

    // Método para eliminar un evento según su nombre exacto
    public static void eliminarEvento(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < totalEventos; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                // Mover los eventos restantes una posición hacia atrás
                for (int j = i; j < totalEventos - 1; j++) {
                    nombres[j] = nombres[j + 1];
                    fechas[j] = fechas[j + 1];
                    descripciones[j] = descripciones[j + 1];
                }
                totalEventos--; // Reducir el contador de los eventos
                System.out.println("Evento eliminado con exito.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Evento no encontrado.");
        }
    }
    
    // Método para validar el formato de la fecha
    public static boolean Fecha(String fecha) {
        // Verificar que la longitud sea correcta (8 caracteres: **/**/****)
        if (fecha.length() != 10) {
            return false;
        }

        // Verificar que los separadores sean '/'
        if (fecha.charAt(2) != '/' || fecha.charAt(5) != '/') {
            return false;
        }

        // Verificar que los demás caracteres sean números
        try {
            int dia = Integer.parseInt(fecha.substring(0, 2));
            int mes = Integer.parseInt(fecha.substring(3, 5));
            int anio = Integer.parseInt(fecha.substring(6, 10));

            // Validar rangos de día, mes y año
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 1000 || anio > 9999) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false; // Si no se pueden convertir a números, el formato es incorrecto
        }

        return true;
    }
    
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println(); // Imprime 50 líneas en blanco
        }
    }
}
