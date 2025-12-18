public class Tablero {
    private Celda[][] grilla;
    private int filas, columnas;

 // Constructor que recibe la grilla ya armada (cumple con Inyección de Dependencias)
    public Tablero(Celda[][] grilla, int filas, int columnas) {
        this.grilla = grilla;
        this.filas = filas;
        this.columnas = columnas;
    }
    
    public boolean evolucionar() {
        // 1. Calcular siguiente estado para todos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int vecinos = contarVecinosVivos(i, j);
                grilla[i][j].prepararSiguienteGeneracion(vecinos);
            }
        }

        // 2. Actualizar y verificar si hubo cambios
        boolean huboCambios = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (grilla[i][j].actualizarEstado()) huboCambios = true;
            }
        }
        return huboCambios;
    }

    private int contarVecinosVivos(int f, int c) {
        int vivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nf = f + i;
                int nc = c + j;
                if (nf >= 0 && nf < filas && nc >= 0 && nc < columnas) {
                    if (grilla[nf][nc].estaVivo()) vivos++;
                }
            }
        }
        return vivos;
    }
    
    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(grilla[i][j].getSimbolo() + " ");
            }
            System.out.println();
        }
    }
}