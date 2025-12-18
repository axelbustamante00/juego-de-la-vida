public class Celda {
    private EstadoCelda estadoActual;
    private EstadoCelda estadoSiguiente;

    public Celda(EstadoCelda estadoInicial) {
        this.estadoActual = estadoInicial;
    }

    public void prepararSiguienteGeneracion(int vecinosVivos) {
        // Delegamos la lógica al objeto estado
        this.estadoSiguiente = estadoActual.calcularSiguiente(vecinosVivos);
    }

    public boolean actualizarEstado() {
        boolean cambio = !estadoActual.getClass().equals(estadoSiguiente.getClass());
        this.estadoActual = estadoSiguiente;
        return cambio;
    }

    public boolean estaVivo() { return estadoActual.estaVivo(); }
    public char getSimbolo() { return estadoActual.getSimbolo(); }
}