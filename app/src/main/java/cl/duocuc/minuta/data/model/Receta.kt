package cl.duocuc.minuta.data.model


/**
 * Clase de datos que representa una receta de cocina.
 *
 * Caracterostica de esta clase
 * Inmutabilidad: todos los campos son val lo que significa que una vez creada
 *                la instancia, sus valores no pueden cambiar.
 * Data class: Kotlin genera automaticamente métodos utiles como
 *             equals(), hashcode(), toString() y copy()
 * Estructura simple: Representa de forma clara los elementos esenciales de una receta
 * Flexibilidad: La lista de ingredientes permite manejar cualquier cantidad de elementos
 *
 * Esta data class encapsula toda la información necesaria para definir
 * una receta, incluyendo cuando prepararla, que ingredientes necesita
 * y consejos adicionales para su preparación.
 */
data class Receta(
    /**
     * Día de la semana para el cual está planificada esta receta
     */
    val dia: String,
    /**
     * Nombre descriptivo de la receta
     */
    val nombre: String,
    /**
     * Lista de ingredientes necesarios para preparar la receta
     * Cada elemento de la lista representa un ingrediente específico
     * con su cantidad correpondiente
     */
    val ingredientes: List<String>,
    /**
     * Consejos, tips o instrucciones adicionales para la preparación
     * Puede incluir información sbre tiempo de cocción, técnicas especiales etc.
     */
    val recomendaciones: String
)
