public class EstadoLatente implements EstadoCelda {
    @Override
    public boolean estaVivo() { return false; } // Se considera muerta

    @Override
    public EstadoCelda calcularSiguiente(int vecinosVivos) {
        if (vecinosVivos == 1) return new EstadoVivo();
        return this;
    }

    @Override
    public char getSimbolo() { return 'L'; }
}