package cl.duocuc.minuta.data.local

import cl.duocuc.minuta.data.model.Receta


/**
 *  val recetaSemana = listOf(..)
 *
 *  val: Variable inmutable (no se puede reasiganr después de su creación)
 *  recetasSemana: Nombre de la variable que sugiere que contiene recetas para toda la
 *  semana
 *  listOf(): Función kotlin que crea una lista inmutable de elementos
 */
val recetasSemana = listOf(
    Receta(
        "Lunes",
        "Ensalada de Quinoa",
        listOf("Quinoa", "Tomate", "Palta", "Limón"),
        "Rica en fibra y proteínas vegetales."
    ),
    Receta(
        "Martes",
        "Pollo al horno con verduras",
        listOf("Pechuga de pollo", "Zanahoria", "Brócoli", "Papas"),
        "Fuente de proteínas magras y vitaminas."
    ),
    Receta(
        "Miércoles",
        "Sopa de verduras frescas",
        listOf("Zanahoria", "Zapallo", "Apio", "Cebolla"),
        "Baja en calorías, rica en minerales."
    ),
    Receta(
        "Jueves",
        "Pescado a la plancha",
        listOf("Reineta", "Limón", "Ensalada verde"),
        "Rico en omega-3 y proteínas."
    ),
    Receta(
        "Viernes",
        "Pasta integral con salsa de tomate",
        listOf("Pasta integral", "Tomate", "Albahaca"),
        "Buena fuente de energía y antioxidantes."
    ),
    Receta(
        "Sábado",
        "Cazuela de vacuno",
        listOf("Carne de vacuno", "Zapallo", "Choclo", "Papa"),
        "Plato tradicional chileno, nutritivo y reconfortante."
    ),
    Receta(
        "Domingo",
        "Tortilla de verduras",
        listOf("Huevos", "Espinaca", "Zanahoria", "Cebolla"),
        "Alta en proteínas y vitaminas, ideal para cerrar la semana."
    )
)
