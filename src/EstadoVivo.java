// Implementación: Estado VIVO
public class EstadoVivo implements EstadoCelda {
    @Override
    public boolean estaVivo() { return true; }

    @Override
    public EstadoCelda calcularSiguiente(int vecinosVivos) {
        if (vecinosVivos < 2 || vecinosVivos > 3) return new EstadoMuerto();
        return this; // Sobrevive
    }

    @Override
    public char getSimbolo() { return 'O'; }
}