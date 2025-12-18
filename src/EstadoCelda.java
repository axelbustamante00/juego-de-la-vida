// Interfaz para los estados
public interface EstadoCelda {
    boolean estaVivo();
    EstadoCelda calcularSiguiente(int vecinosVivos);
    char getSimbolo();
}