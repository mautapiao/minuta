package cl.duocuc.minuta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.duocuc.minuta.ui.screens.auth.LoginScreen
import cl.duocuc.minuta.ui.screens.auth.RecuperarPasswordScreen
import cl.duocuc.minuta.ui.screens.auth.RegistroScreen
import cl.duocuc.minuta.ui.screens.minuta.DetalleRecetaScreen
import cl.duocuc.minuta.ui.screens.minuta.MinutaScreen

/**
 * Clase Main activity: Es la actividad principal de la aplicación
 *
 * ComponentActivity(): Clase base de android para actividades que usan JetPack Compose
 */
class MainActivity : ComponentActivity() {
    /**
     * onCreate: Método que se ejcuta cuando se crea la actividad
     * setContent: define el conetenido UI usando Jetpack Compose
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /**
             * Sistema de navegación
             *
             * MaterialTheme: Aplica el tema Material Design
             * navController: Controle la navegación entre pantallas
             * navHost: Contenedor que define todas las rutas de navegación
             * startDestination = "login": La app inicia en la pantalla de login
             */
            MaterialTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "login") {

                    /**
                     *  Pantalla de login
                     *  Navegación: 3 opciones según la accion del usuario
                     *  Callback: Funciones lambda que se ejecutan al tocar botones
                     *            una función lambda es una función anónina (sin nombre)
                     *            que se puede tratar como un valor y pasar como parámetro a
                     *            otras funciones
                     */
                    composable("login") {
                        LoginScreen(
                            onLogin = { navController.navigate("minuta") },
                            onRegister = { navController.navigate("registro") },
                            onForgotPassword = { navController.navigate("recuperar") }
                        )
                    }
                    /**
                     * Pantalla de registro
                     * popBackstack(): Regresa a la pantalla anterior (login)
                     */
                    composable("registro") {
                        RegistroScreen(onRegisterDone = { navController.popBackStack() })
                    }
                    /**
                     * Pantalla de recuperar contraseña
                     * popBackstack(): Regresa a la pantalla anterior (login)
                     */
                    composable("recuperar") {
                        RecuperarPasswordScreen(onBack = { navController.popBackStack() })
                    }
                    /**
                     * Pantalla de minuta
                     */
                    composable("minuta") {
                        MinutaScreen(
                            onRecetaClick = { dia -> navController.navigate("detalle/$dia") },
                            onLogout = {

                                navController.navigate("login") {
                                    popUpTo("login") { inclusive = true }
                                }
                            }
                        )
                    }
                    /**
                     * Pantalla de detalle de receta con parámetros
                     * Ruta dinámica: detalle/{dia} donde {dia} es un parámetro
                     * Extracción del parámetro: Obtiene el día desde los argumentos de navegación
                     * Seguridad: Usa .orEmpty() para evitar valores null
                     */
                    composable(
                        "detalle/{dia}",
                        /**
                         * arguments: Lista que define qué parámetros acepta esta ruta
                         * navArgument("dia"): Crea un argumento llamado "dia"
                         *                  el nombre debe coincidir con {dia} de la ruta
                         * type = NavType.StringType: Especifica que el parámetro es un String
                         *                  otros tipos: NavType.IntType, NavType.BoolType, etc
                         */
                        arguments = listOf(navArgument("dia") { type = NavType.StringType })
                    ) {

                        /**
                         * backStackEntry: Parámetro que contiene información de la navegación actual
                         * Incluye los argumentos pasados desde la pantalla anterior
                         * backStackEntry es proporcionado automáticamente por el sistema
                         */

                            backStackEntry ->

                        /**
                         * backStackEntry.arguments: accede a los argumentos enviados
                         * ? operador seguro por si arguments es null
                         * getString("dia"): Obtener el valor del parámetro "dia" como String
                         * .orEmpty(): Si el valor es null, devuelve una cadena vacia ""
                         */
                        val dia = backStackEntry.arguments?.getString("dia").orEmpty()

                        /**
                         * Creación de la pantalla
                         * DetalleRecetaScreen: composable que muestra el detalle de la receta
                         * dia = dia : Pasa el parametro extraido al composable
                         * onBack = { navController.porBackStack()}: Lambda que define que hacer al
                         * presionar atrás-
                         */
                        DetalleRecetaScreen(dia = dia, onBack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}