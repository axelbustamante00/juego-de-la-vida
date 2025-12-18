Juego de la Vida - Solución Orientada a Objetos
Este proyecto es una implementación en Java del Juego de la Vida de John Conway, extendido con estados dinámicos (Enferma y Latente). La solución pone énfasis en los principios SOLID y el uso de patrones de diseño para lograr un código extensible y mantenible.

🚀 Instrucciones de Ejecución
Requisitos
Java JDK 8 o superior instalado.

Compilación
Desde la terminal, ubicado en la carpeta raíz del proyecto:

javac src/*.java -d bin

Ejecución

java -cp bin Main

📂 Estructura de Archivos Semilla
El sistema permite cargar estados iniciales desde archivos de texto dentro de la carpeta ejemplos/. El formato requerido es:

1.Primera línea: filas columnas (enteros).

2.Líneas siguientes: Caracteres que representan el estado (. muerto, X vivo, L latente, E enfermo).

🏗️ Diseño de la Solución
Arquitectura y Patrones
La solución se basa en el Patrón State (Estado).

Abstracción y Polimorfismo: Se definió la interfaz EstadoCelda. Cada estado posible de una celda (Vivo, Muerto, Enfermo, Latente) es una clase que implementa esta interfaz. La Celda no conoce las reglas del juego; simplemente delega la responsabilidad de calcular el próximo estado a su objeto Estado actual.

Delegación: La clase Celda actúa como un contexto que mantiene el estado, pero la lógica de evolución reside en las clases de estado.

Principio de Responsabilidad Única (SRP): El Tablero se encarga de la gestión de la grilla y la iteración, mientras que la lógica de las reglas está encapsulada en los estados.

Principio Open/Closed: Para agregar la regla de la "Celda Enferma" (25% de probabilidad), se utilizó Herencia creando la clase EstadoVivoVulnerable que extiende de EstadoVivo. Esto permitió añadir la nueva funcionalidad sin modificar el código original de EstadoVivo.

Manejo de la Evolución
Para cumplir con el requisito de que el cálculo de una generación no afecte a las demás celdas en el mismo paso:

El Tablero realiza una primera pasada calculando el "estado siguiente" de cada celda sin modificar el actual.

Realiza una segunda pasada para actualizar todos los estados simultáneamente.

Si en la segunda pasada no se detectan cambios en ninguna celda, el sistema corta la ejecución automáticamente.

🛠️ Cómo Extender el Juego
Este diseño permite añadir nuevas reglas con cambios mínimos:

Crear una nueva clase que implemente EstadoCelda.

Definir la lógica de transición en el método calcularSiguiente(int vecinosVivos).

Agregar el nuevo carácter correspondiente en la clase CargadorTablero.
