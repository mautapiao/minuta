package cl.duocuc.minuta.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.duocuc.minuta.R
// Para el componente Icon
import androidx.compose.material3.Icon

@Composable
fun LoginScreen(onLogin: () -> Unit, onRegister: () -> Unit, onForgotPassword: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var showErrors by remember { mutableStateOf(false) }

    // Regex para email más preciso
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()

    /**
     * Valida el formato y contenido de un email
     * @param email String del email a validar
     * @return String vacío si es válido, mensaje de error si no es válido
     */
    fun validarEmail(email: String): String {
        // Verifica si el email está vacío
        if (email.isEmpty()) {
            // Solo muestra error si showErrors es true
            if (showErrors) return "El correo es requerido"
            else return ""
        }

        // Valida el formato usando expresión regular
        if (!emailRegex.matches(email)) {
            return "Formato de correo inválido"
        }

        // Si pasa todas las validaciones, retorna string vacío (válido)
        return ""
    }

    /**
     * Valida que la contraseña cumpla con los requisitos de seguridad
     * @param password String de la contraseña a validar
     * @return String vacío si es válida, mensaje de error si no cumple requisitos
     */
    fun validarPassword(password: String): String {
        // Verifica si la contraseña está vacía
        if (password.isEmpty()) {
            // Solo muestra error si showErrors es true
            if (showErrors) return "La contraseña es requerida"
            else return ""
        }

        // Verifica longitud mínima de 6 caracteres
        if (password.length < 6) {
            return "Mínimo 6 caracteres"
        }

        // Verifica que contenga al menos un número
        // any() es una función de alto orden que verifica si algún elemento cumple la condición
        if (!password.any { it.isDigit() }) {
            return "Debe contener al menos un número"
        }

        // Si pasa todas las validaciones, retorna string vacío (válido)
        return ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_uc),
            contentDescription = "Logo UC",
            modifier = Modifier
                .fillMaxWidth(0.6f) // Ocupa 60% del ancho de pantalla
                .height(120.dp)     // Alto fijo rectangular
        )

        Spacer(modifier = Modifier.height(24.dp)) // Espacio debajo de la imagen

        Text("Iniciar sesión", style = MaterialTheme.typography.headlineMedium)

        /**
         * Campo de texto para ingresar el correo electrónico con validación en tiempo real
         */
        OutlinedTextField(
            // Valor actual del campo (vinculado a la variable de estado email)
            value = email,

            // Función que se ejecuta cada vez que el usuario escribe en el campo
            onValueChange = {
                email = it                    // Actualiza el valor del email
                emailError = validarEmail(it) // Valida el nuevo valor y actualiza el error
            },

            // Etiqueta que aparece como placeholder y se anima al escribir
            label = { Text("Correo electrónico") },

            // Restringe el campo a una sola línea (no permite saltos de línea)
            singleLine = true,

            // Modifica el diseño para que ocupe todo el ancho disponible
            modifier = Modifier.fillMaxWidth(),

            // Indica si el campo tiene error (cambia el color del borde a rojo)
            isError = emailError.isNotEmpty(), // True si hay mensaje de error

            // Texto de ayuda que aparece debajo del campo
            supportingText = if (emailError.isNotEmpty()) {
                // Si hay error, muestra el mensaje en color rojo
                { Text(emailError, color = MaterialTheme.colorScheme.error) }
            } else null, // Si no hay error, no muestra texto de ayuda

            // Icono que aparece al inicio (lado izquierdo) del campo
            leadingIcon = {
                Icon(
                    // Usa el icono predefinido de email de Material Icons
                    imageVector = Icons.Default.Email,

                    // Descripción para accesibilidad (null porque es decorativo)
                    contentDescription = null,

                    // Color del icono que cambia según el estado del campo
                    tint = if (emailError.isNotEmpty())
                        MaterialTheme.colorScheme.error        // Rojo si hay error
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant // Color normal
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        /**
         * Campo de texto para contraseña con validación en tiempo real y ocultación de caracteres
         * Características específicas:
         * - Transforma el texto a puntos/asteriscos para ocultar la contraseña
         * - Muestra texto de ayuda constante con los requisitos
         * - Validación automática con feedback visual
         * - Icono de candado que cambia color según el estado
         */
        OutlinedTextField(
            // GESTIÓN DEL VALOR
            // value: Contiene el texto actual de la contraseña
            // Aunque se muestra oculto, internamente mantiene el texto real
            value = password,

            // CALLBACK DE CAMBIO
            // onValueChange: Se ejecuta cada vez que el usuario modifica la contraseña
            onValueChange = {
                password = it                      // Actualiza la variable de estado
                passwordError = validarPassword(it) // Valida requisitos de seguridad inmediatamente
            },

            // ELEMENTOS VISUALES
            // label: Etiqueta que se anima hacia arriba cuando el campo está activo
            label = { Text("Contraseña") },

            // CONFIGURACIÓN DE COMPORTAMIENTO
            // singleLine: Previene saltos de línea (importante en contraseñas)
            singleLine = true,

            // DISEÑO Y LAYOUT
            // modifier: Hace que el campo ocupe todo el ancho del contenedor padre
            modifier = Modifier.fillMaxWidth(),

            // TRANSFORMACIÓN VISUAL ESPECIAL
            // visualTransformation: Convierte cada carácter en puntos/asteriscos
            // Esto oculta la contraseña mientras el usuario escribe, pero mantiene el valor real
            visualTransformation = PasswordVisualTransformation(),

            // GESTIÓN DE ESTADOS DE ERROR
            // isError: Cambia la apariencia del campo cuando hay errores de validación
            // Se activa cuando passwordError contiene algún mensaje
            isError = passwordError.isNotEmpty(),

            // TEXTO DE AYUDA
            // supportingText: Muestra diferentes mensajes según el estado del campo
            supportingText = if (passwordError.isNotEmpty()) {
                // CASO 1: Si hay error, muestra el mensaje específico en rojo
                { Text(passwordError, color = MaterialTheme.colorScheme.error) }
            } else {
                // CASO 2: Si no hay error, muestra los requisitos como guía
                // Ayuda al usuario a conocer las reglas antes de cometer errores
                { Text("Mínimo 6 caracteres con al menos un número",
                    color = MaterialTheme.colorScheme.onSurfaceVariant) }
            },

            // ICONO INDICATIVO
            // leadingIcon: Icono de candado al inicio del campo
            leadingIcon = {
                Icon(
                    // Usa el icono de candado de Material Design
                    imageVector = Icons.Default.Lock,

                    // Sin descripción porque es decorativo
                    contentDescription = null,

                    // COLOR DINÁMICO DEL ICONO
                    // Cambia entre color de error y color normal según el estado
                    tint = if (passwordError.isNotEmpty())
                        MaterialTheme.colorScheme.error        // Rojo cuando hay error
                    else
                        MaterialTheme.colorScheme.onSurfaceVariant // Gris normal
                )
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        /**
         * Botón principal para ejecutar el proceso de inicio de sesión
         * Características:
         * - Validación completa antes de proceder
         * - Habilitado solo cuando hay contenido en ambos campos
         * - Activa la visualización de errores al hacer clic
         * - Ejecuta callback de login solo si la validación es exitosa
         */
        Button(
            // EVENTO DE CLIC - LÓGICA PRINCIPAL
            onClick = {
                // PASO 1: ACTIVAR VISUALIZACIÓN DE ERRORES
                // Fuerza a mostrar todos los errores, incluso en campos vacíos
                // Esto es útil cuando el usuario intenta hacer login sin completar los campos
                showErrors = true // Cambia el comportamiento de las funciones de validación

                // PASO 2: VALIDACIÓN COMPLETA
                // Re-valida ambos campos para asegurar que están correctos
                // Esto es importante porque el usuario pudo haber modificado los campos
                emailError = validarEmail(email)       // Valida formato y contenido del email
                passwordError = validarPassword(password) // Valida requisitos de la contraseña

                // PASO 3: VERIFICACIÓN DE ÉXITO
                // Solo procede si ambas validaciones pasaron (sin errores)
                if (emailError.isEmpty() && passwordError.isEmpty()) {
                    // EJECUCIÓN DEL LOGIN
                    // onLogin() es una función callback que maneja la lógica de autenticación
                    // Normalmente haría una petición al servidor o autenticación local
                    onLogin()

                    // LOG DE DEPURACIÓN
                    // Mensaje en consola para desarrollo/debugging
                    // En producción se podría remover o usar un logger apropiado
                    println("Login exitoso")
                }
                // NOTA: Si hay errores, no se ejecuta onLogin() y los errores se muestran automáticamente
                // gracias a que showErrors = true y la revalidación actualiza los estados de error
            },

            // DISEÑO Y LAYOUT
            // modifier: Hace que el botón ocupe todo el ancho disponible
            // Esto crea una apariencia más prominente y fácil de tocar en móviles
            modifier = Modifier.fillMaxWidth(),

            // CONTROL DE ESTADO HABILITADO/DESHABILITADO
            // enabled: Controla si el botón está activo o inactivo
            // Solo se habilita cuando AMBOS campos tienen contenido (no vacíos)
            // Esto previene clics innecesarios cuando obviously faltan datos
            enabled = email.isNotEmpty() && password.isNotEmpty()

        ) {
            // CONTENIDO DEL BOTÓN
            // Texto simple y claro que indica la acción
            Text("Iniciar Sesión")
        }

        TextButton(onClick = onRegister) {
            Text("Registrarse")
        }

        TextButton(onClick = onForgotPassword) {
            Text("Olvidé mi contraseña")
        }

    }
}

// ----- Preview -----
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    MaterialTheme {
        LoginScreen(
            onLogin = {},
            onRegister = {},
            onForgotPassword = {}
        )
    }
}

/*
        FLUJO COMPLETO DEL BOTÓN:
        1. Usuario llena email y contraseña → Botón se habilita
        2. Usuario hace clic → Se activa showErrors = true
        3. Se ejecutan ambas validaciones
        4. Si todo está correcto → Se ejecuta onLogin()
        5. Si hay errores → Se muestran en los campos automáticamente
        6. Usuario corrige errores y repite el proceso

        BENEFICIOS DE ESTE PATRÓN:
        - Prevención proactiva: No permite clic en campos vacíos
        - Validación final: Re-verifica antes de proceder
        - Feedback claro: Muestra errores específicos si algo falla
        - UX fluida: Solo ejecuta login cuando todo está correcto

        Ref.
        https://medium.com/@rzmeneghelo/how-to-validate-fields-using-jetpack-compose-in-android-43be70597e82
 */
