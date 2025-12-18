public class EstadoEnfermo implements EstadoCelda {
    @Override
    public boolean estaVivo() { return true; } // Se considera viva

    @Override
    public EstadoCelda calcularSiguiente(int vecinosVivos) {
        return new EstadoMuerto(); // Muere si o si
    }

    @Override
    public char getSimbolo() { return 'E'; }
}

