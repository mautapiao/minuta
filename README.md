# Minuta Semanal 🍎

Este proyecto corresponde a la primera entrega de la actividad formativa **"Integrando los componentes básicos de una aplicación móvil"**.

## 📝 Descripción del Proyecto

**Minuta Semanal** es una aplicación móvil desarrollada en Android nativo que tiene como objetivo facilitar la planificación de
comidas semanales para dueñas de casa y usuarios con baja habilidad informática. La aplicación ofrece una minuta nutricional 
con 7 recetas sugeridas para la semana, junto con sus recomendaciones, presentadas en una interfaz clara, sencilla y fácil de navegar.

El diseño se centra en la **experiencia del usuario (UX)**, eliminando la complejidad y priorizando la usabilidad
para garantizar que cualquier persona pueda seleccionar y preparar sus comidas diarias sin esfuerzo.

## ✨ Características Principales

*   🔐 **Gestión de Usuarios:**
    *   Pantalla de **Login** para acceso seguro.
    *   Pantalla de **Registro** para nuevos usuarios.
    *   Pantalla para **Recuperar Contraseña**.
*   📅 **Planificador Semanal:**
    *   Visualización de una minuta con 7 recetas para la semana.
    *   Acceso a recomendaciones nutricionales para cada receta.
*   📱 **Diseño Adaptativo:**
    *   Interfaz que se ajusta correctamente a múltiples tamaños de pantalla de dispositivos Android.

## 🛠️ Stack Tecnológico y Requerimientos Técnicos

Este proyecto fue desarrollado cumpliendo con los siguientes requerimientos técnicos:

*   **IDE:** Android Studio Narwhal Feature Drop | 2025.1.2.
*   **Lenguaje:** Kotlin.
*   **UI Toolkit:** Jetpack Compose para la construcción de una interfaz de usuario declarativa, moderna y reactiva.
*   **Diseño:** Componentes de Material Design 3, siguiendo las guías de diseño de Google para una apariencia limpia y consistente.
*   **Versionamiento:** El código fuente está gestionado a través de un repositorio Git.

### Repositorio del Proyecto
El código fuente completo está disponible en el siguiente repositorio:
[**Haz clic aquí para ir al repositorio Git**](https://github.com/mautapiao/minuta.git)

---

## ✅ Requerimientos Cumplidos en esta Entrega

A continuación se detalla el cumplimiento de cada uno de los requerimientos solicitados para esta entrega.

#### 1. Diseño de Interfaz Intuitiva
La interfaz ha sido diseñada con **Jetpack Compose**, priorizando la simplicidad y la claridad. Se utilizan componentes grandes, textos legibles y una navegación lógica para facilitar su uso por parte de usuarios con poca experiencia tecnológica.

#### 2. Vistas de Gestión de Usuario
Se han desarrollado las siguientes vistas, integrando componentes de Material Design y Jetpack Compose:
*   **Login (`ui/screens/auth/LoginScreen.kt`)**: Incluye campos de texto (`TextField`) para email/contraseña y un botón (`Button`) para iniciar sesión.
*   **Registro de Usuario (`ui/screens/auth/RegistroScreen.kt`)**: Formulario con `TextFields` para datos personales, `Checkbox` para aceptar términos y un botón de registro.
*   **Recuperar Contraseña (`ui/screens/auth/RecuperarPasswordScreen.kt`)**: Campo de texto para el email y un botón para enviar el enlace de recuperación.

#### 3. Integración de Componentes UI
La aplicación integra una variedad de componentes de Material Design 3 y Jetpack Compose para cumplir con los requisitos:

*   **Inputs:** `TextField` y `OutlinedTextField` para la entrada de datos.
*   **Botones:** `Button`, `TextButton` y `IconButton`.
*   **Vínculos:** Textos con formato especial (`ClickableText`) para acciones como "Olvidé mi contraseña".
*   **Textos:** `Text` con diferentes estilos tipográficos de Material Design (`Typography`).
*   **Check list:** `Checkbox` utilizado en la pantalla de registro.
*   **Radio buttons:** `RadioButton` para selección de opciones únicas (ej. género, preferencias).
*   **Grillas/Tablas:** Se utiliza `LazyColumn` y `LazyVerticalGrid` para mostrar la lista de recetas de forma eficiente.
*   **Combo box (Dropdown):** Implementado con `ExposedDropdownMenuBox` para seleccionar categorías o filtros.

#### 4. Almacenamiento de Datos (Array)
Para esta entrega inicial, la view de **Minuta** (`ui/screens/minuta/MinutaScreen.kt`) consume los datos desde un `array` (una `List<Recipe>`) que se encuentra definido en el código. Este array almacena 7 recetas de ejemplo con sus nombres y recomendaciones nutricionales correspondientes, simulando una fuente de datos local.

#### 5. Aplicación Adaptativa
El uso de Jetpack Compose permite que la UI sea inherentemente adaptativa. Se utilizan modificadores como `fillMaxWidth()`, `weight()` y `ConstraintLayout` en Compose para asegurar que los elementos se reorganicen y escalen adecuadamente en diferentes densidades y tamaños de pantalla.

---

## 🚀 Cómo Ejecutar el Proyecto

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/mautapiao/minuta.git
    ```
2.  **Abrir en Android Studio:**
    *   Abre Android Studio.
    *   Selecciona `Open` y navega hasta la carpeta del proyecto clonado.
3.  **Sincronizar Gradle:**
    *   Espera a que Android Studio descargue y sincronice todas las dependencias del proyecto (verás una barra de progreso en la parte inferior).
4.  **Ejecutar la aplicación:**
    *   Selecciona un emulador de Android o conecta un dispositivo físico.
    *   Presiona el botón `Run 'app'` (el ícono de play verde).

## 👤 Iniciar Sesión
Puede utilizar cualquier correo valido y password mayor a 6 caracteres, solo es para efectos demostrativos.

## 👤 Autor

*   **Mauricio Tapia Ortega**