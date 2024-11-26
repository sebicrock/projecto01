package reto1;

import java.util.Random;
import java.util.Scanner;



public class classePrincipal {


    // Colores para formato en consola
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";

    // Constantes
    private static final double VELOCIDAD_BASE = 100000.0; // km/h, velocidad genérica
    private static double velocidadSeleccionada = VELOCIDAD_BASE; // Velocidad de la nave seleccionada

    // Variables de destino, nave y recursos
    private static String destinoSeleccionado = "";
    private static double distanciaDestino = 0.0;
    private static double tiempoEstimado = 0.0;
    private static String naveSeleccionada = "";
    private static int cantidadPasajeros = 0;
    private static double combustible = 0.0; // en litros
    private static double oxigeno = 0.0; // en horas
    private static double distanciaRecorrida = 0.0;
    private static double tiempoRestante = 0.0;
    private static boolean viajeEnCurso = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarBienvenida();

        while (true) {
            mostrarMenuPrincipal();

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    seleccionarDestino(scanner);
                    break;
                case 2:
                    seleccionarNave(scanner);
                    break;
                case 3:
                    ingresarCantidadPasajeros(scanner);
                    break;
                case 4:
                    calcularDistanciaYTiempo();
                    break;
                case 5:
                    gestionarRecursos(scanner);
                    break;
                case 6:
                    iniciarViaje(scanner);
                    break;
                case 7:
                    simularViaje(scanner);
                    break;
                case 8:
                    System.out.println("¡Gracias por usar el sistema! Hasta luego.");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private static void mostrarBienvenida() {
        System.out.println(BLUE + "  ^" + RESET);
        System.out.println(BLUE + " / \\" + RESET);
        System.out.println(BLUE + "/___\\" + RESET);
        System.out.println(BLUE + "|   |" + RESET + "                 BIENVENIDO A ESTE VIAJE ESPACIAL");
        System.out.println(BLUE + "|___|" + RESET);
        System.out.println(RED + " | |" + RESET);
        System.out.println(YELLOW + " ***" + RESET);
        System.out.println(YELLOW + "*****" + RESET);
        System.out.println();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("*******************************************");
        System.out.println("        SISTEMA DE GESTIÓN DE VIAJES       ");
        System.out.println("*******************************************");
        System.out.println("1. Selección de Destino");
        System.out.println("2. Selección de Nave");
        System.out.println("3. Ingresar Cantidad de Pasajeros");
        System.out.println("4. Cálculo de Distancia y Tiempo de Viaje");
        System.out.println("5. Gestión de Recursos");
        System.out.println("6. Iniciar Viaje");
        System.out.println("7. Simular Viaje");
        System.out.println("8. Salir");
        System.out.println("*******************************************");
    }

    private static void seleccionarDestino(Scanner scanner) {
        System.out.println("\n--- Selección de Destino ---");
        System.out.println("Planetas disponibles:");
        System.out.println("1. Marte (225 millones de km)");
        System.out.println("2. Júpiter (778 millones de km)");
        System.out.println("3. Saturno (1,427 millones de km)");


        System.out.print("Selecciona tu destino (1-7): ");
        int opcion = scanner.nextInt();

        switch (opcion) {

            case 1 -> {
                destinoSeleccionado = "Marte";
                distanciaDestino = 225_000_000;
            }
            case 2 -> {
                destinoSeleccionado = "Júpiter";
                distanciaDestino = 778_000_000;
            }
            case 3 -> {
                destinoSeleccionado = "Saturno";
                distanciaDestino = 1_427_000_000;
            }

            default -> {
                System.out.println("Opción no válida. Por favor, selecciona un destino válido.");
                return;
            }
        }

        System.out.println("\nHas seleccionado el destino: " + destinoSeleccionado);
        System.out.println("Distancia desde la Tierra: " + distanciaDestino + " km");
    }

    private static void seleccionarNave(Scanner scanner) {
        System.out.println("\n--- Selección de Nave ---");
        System.out.println("Naves disponibles:");
        System.out.println("1. Apolo XI (Velocidad: 120,000 km/h, Capacidad: 3 pasajeros)");
        System.out.println("2. SpaceX Dragon (Velocidad: 150,000 km/h, Capacidad: 7 pasajeros)");
        System.out.println("3. Discovery (Velocidad: 100,000 km/h, Capacidad: 5 pasajeros)");

        System.out.print("Selecciona tu nave (1-3): ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1 -> {
                naveSeleccionada = "Apolo XI";
                velocidadSeleccionada = 120_000;
            }
            case 2 -> {
                naveSeleccionada = "SpaceX Dragon";
                velocidadSeleccionada = 150_000;
            }
            case 3 -> {
                naveSeleccionada = "Discovery";
                velocidadSeleccionada = 100_000;
            }
            default -> {
                System.out.println("Opción no válida. Por favor, selecciona una nave válida.");
                return;
            }
        }

        System.out.println("\nHas seleccionado la nave: " + naveSeleccionada);
        System.out.println("Velocidad máxima: " + velocidadSeleccionada + " km/h");
    }

    private static void ingresarCantidadPasajeros(Scanner scanner) {
        System.out.println("\n--- Ingresar Cantidad de Pasajeros ---");

        while (true) {
            System.out.print("Introduce la cantidad de pasajeros: ");
            int pasajeros = scanner.nextInt();

            if (pasajeros > 0) {
                cantidadPasajeros = pasajeros;
                System.out.println("Cantidad de pasajeros registrada: " + cantidadPasajeros);
                break;
            } else {
                System.out.println("Por favor, introduce un número positivo.");
            }
        }
    }

    private static void calcularDistanciaYTiempo() {
        if (destinoSeleccionado.isEmpty() || naveSeleccionada.isEmpty()) {
            System.out.println("\nPrimero debes seleccionar un destino y una nave.");
            return;
        }

        tiempoEstimado = distanciaDestino / velocidadSeleccionada; // Tiempo en horas

        System.out.println("\n--- Cálculo de Distancia y Tiempo de Viaje ---");
        System.out.println("Destino seleccionado: " + destinoSeleccionado);
        System.out.println("Distancia: " + distanciaDestino + " km");
        System.out.println("Velocidad de la nave: " + velocidadSeleccionada + " km/h");
        System.out.printf("Tiempo estimado de viaje: %.2f horas (%.2f días)\n",
                tiempoEstimado, tiempoEstimado / 24);
    }

    private static void gestionarRecursos(Scanner scanner) {
        System.out.println("\n--- Gestión de Recursos ---");

        if (destinoSeleccionado.isEmpty() || naveSeleccionada.isEmpty()) {
            System.out.println("Primero debes seleccionar un destino y una nave.");
            return;
        }

        // Recalcular recursos necesarios
        combustible = distanciaDestino / 1000.0; // 1 litro por 1000 km
        oxigeno = tiempoEstimado * 1.5 * cantidadPasajeros; // 1.5 horas de oxígeno por pasajero

        System.out.printf("Combustible necesario: %.2f litros\n", combustible);
        System.out.printf("Oxígeno necesario: %.2f horas\n", oxigeno);

        System.out.println("\n¿Deseas ajustar los recursos antes de partir? (S/N): ");
        String respuesta = scanner.next();

        if (respuesta.equalsIgnoreCase("S")) {
            System.out.print("Introduce la cantidad de combustible (litros): ");
            combustible = scanner.nextDouble();
            System.out.print("Introduce la cantidad de oxígeno (horas): ");
            oxigeno = scanner.nextDouble();
        }
    }

    private static void iniciarViaje(Scanner scanner) {
        if (destinoSeleccionado.isEmpty() || naveSeleccionada.isEmpty() || cantidadPasajeros == 0) {
            System.out.println("\nPrimero debes seleccionar destino, nave y cantidad de pasajeros.");
            return;
        }

        System.out.println("\n¡El viaje ha comenzado!");
        System.out.println("Destino: " + destinoSeleccionado);
        System.out.println("Nave: " + naveSeleccionada);
        System.out.println("Cantidad de pasajeros: " + cantidadPasajeros);
        System.out.println("Tiempo estimado de viaje: " + tiempoEstimado + " horas");
        System.out.println("Combustible: " + combustible + " litros");
        System.out.println("Oxígeno: " + oxigeno + " horas");

        viajeEnCurso = true;
    }

    private static void simularViaje(Scanner scanner) {
        if (!viajeEnCurso) {
            System.out.println("\nPrimero debes iniciar un viaje.");
            return;
        }

        Random random = new Random();
        while (distanciaRecorrida < distanciaDestino) {
            // Simulación de eventos aleatorios
            if (random.nextInt(100) < 20) { // 20% de probabilidad de un evento
                System.out.println("\nEvento aleatorio: Un fallo en el sistema de navegación.");
                System.out.println("¿Deseas intentar repararlo o cambiar de rumbo? (R/C): ");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("R")) {
                    System.out.println("Reparación completada, el viaje continúa.");
                } else if (decision.equalsIgnoreCase("C")) {
                    System.out.println("Has cambiado de rumbo. Se estima que se incrementará el tiempo de viaje.");
                    tiempoEstimado += 50; // Incrementamos el tiempo por cambio de rumbo
                }
            }

            // Avanzamos en el viaje
            distanciaRecorrida += velocidadSeleccionada;
            tiempoRestante = (distanciaDestino - distanciaRecorrida) / velocidadSeleccionada;
            oxigeno -= 0.5 * cantidadPasajeros; // Consumo de oxígeno por hora

            System.out.printf("\nProgreso del viaje: %.2f%%\n", (distanciaRecorrida / distanciaDestino) * 100);
            System.out.printf("Tiempo restante: %.2f horas\n", tiempoRestante);
            System.out.printf("Oxígeno restante: %.2f horas\n", oxigeno);

            if (oxigeno <= 0) {
                System.out.println("\nLa nave se quedó sin oxígeno. El viaje ha fracasado.");
                return;
            }

            // Simulamos un retraso para avanzar en el viaje
            try {
                Thread.sleep(10); // Espera 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n¡El viaje ha sido exitoso! Has llegado a " + destinoSeleccionado);
    }
}



