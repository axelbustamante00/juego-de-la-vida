import java.util.Scanner;

public class JuegoVidaCLI {
    private Tablero tablero;
    private Scanner entrada;

    public JuegoVidaCLI() {
        this.entrada = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("--- Juego de la Vida (OO Java) ---");
        System.out.println("1. Cargar desde archivo");
        System.out.println("2. Generar aleatorio");
        System.out.print("Seleccione una opción: ");
        
        try {
            int opcion = Integer.parseInt(entrada.nextLine());
            if (opcion == 1) {
                System.out.print("Ruta del archivo (ej: ejemplos/semilla1.txt): ");
                String ruta = entrada.nextLine();
                tablero = CargadorTablero.cargarDesdeArchivo(ruta);
            } else {
                tablero = CargadorTablero.cargarAleatorio(20, 40);
            }

            menuSimulacion();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void menuSimulacion() {
        System.out.println("\nModo de ejecución:");
        System.out.println("1. Ejecutar N generaciones");
        System.out.println("2. Ejecutar indefinidamente");
        System.out.print("Opción: ");
        int modo = Integer.parseInt(entrada.nextLine());

        int gens = Integer.MAX_VALUE;
        if (modo == 1) {
            System.out.print("Cantidad de generaciones: ");
            gens = Integer.parseInt(entrada.nextLine());
        }

        System.out.print("Intervalo entre pasos (ms): ");
        int ms = Integer.parseInt(entrada.nextLine());

        correrLoop(gens, ms);
    }

    private void correrLoop(int limite, int delay) {
        int g = 0;
        boolean huboCambios = true;

        while (g < limite && huboCambios) {
            limpiarConsola();
            System.out.println("Generación: " + g);
            tablero.imprimir(); // Método que recorre la grilla y hace System.out.print(celda.getSimbolo())
            
            huboCambios = tablero.evolucionar();
            
            if (!huboCambios) {
                System.out.println("\nEl sistema se ha estabilizado (no hay cambios).");
                break;
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            g++;
        }
        System.out.println("Fin de la simulación.");
    }

    private void limpiarConsola() {
        System.out.flush();
    }
}