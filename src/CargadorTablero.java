import java.io.*;
import java.util.*;

public class CargadorTablero {

    public static Tablero cargarDesdeArchivo(String ruta) throws IOException {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo no existe: " + ruta);
        }

        try (Scanner sc = new Scanner(archivo)) {
            if (!sc.hasNextInt()) throw new IOException("Formato inválido: se esperaban filas.");
            int filas = sc.nextInt();
            if (!sc.hasNextInt()) throw new IOException("Formato inválido: se esperaban columnas.");
            int columnas = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            Celda[][] grilla = new Celda[filas][columnas];

            for (int i = 0; i < filas; i++) {
                if (!sc.hasNextLine()) throw new IOException("El archivo tiene menos filas de las indicadas.");
                String linea = sc.nextLine();
                for (int j = 0; j < columnas; j++) {
                    char c = (j < linea.length()) ? linea.charAt(j) : '.';
                    grilla[i][j] = new Celda(convertirSimboloAEstado(c));
                }
            }
            return new Tablero(grilla, filas, columnas);
        }
    }

    public static Tablero cargarAleatorio(int filas, int columnas) {
        Celda[][] grilla = new Celda[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                EstadoCelda estado = (Math.random() < 0.3) ? new EstadoVivoVulnerable() : new EstadoMuerto();
                grilla[i][j] = new Celda(estado);
            }
        }
        return new Tablero(grilla, filas, columnas);
    }

    private static EstadoCelda convertirSimboloAEstado(char c) {
        switch (Character.toUpperCase(c)) {
            case 'X':
            case 'O':
                return new EstadoVivoVulnerable();
            case 'L':
                return new EstadoLatente();
            case 'E':
                return new EstadoEnfermo();
            case '.':
            default:
                return new EstadoMuerto();
        }
    }
}