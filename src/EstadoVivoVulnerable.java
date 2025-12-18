public class EstadoVivoVulnerable extends EstadoVivo {
    
    @Override
    public EstadoCelda calcularSiguiente(int vecinosVivos) {
        // 1. Aplicamos la nueva regla: Probabilidad del 25% de enfermarse
        if (Math.random() < 0.25) {
            return new EstadoEnfermo();
        }
        
        // 2. Si no se enferma, delegamos a la lógica original de EstadoVivo
        // Usamos super para no repetir las reglas de soledad/sobrepoblación
        return super.calcularSiguiente(vecinosVivos);
    }
}