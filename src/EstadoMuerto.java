// Implementación: Estado MUERTO
public class EstadoMuerto implements EstadoCelda {
    @Override
    public boolean estaVivo() { return false; }

    @Override
    public EstadoCelda calcularSiguiente(int vecinosVivos) {
        if (vecinosVivos == 3) return new EstadoVivo();
        return this;
    }

    @Override
    public char getSimbolo() { return '.'; }
}