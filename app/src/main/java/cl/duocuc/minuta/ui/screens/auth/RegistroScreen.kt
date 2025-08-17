package cl.duocuc.minuta.ui.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun RegistroScreen(onRegisterDone: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var aceptarTerminos by remember { mutableStateOf(false) }
    var tipoDieta by remember { mutableStateOf("Omnívora") }

    val opcionesDieta = listOf("Omnívora", "Vegetariana", "Vegana")
    val preferenciasCulinarias = listOf("Chilena", "Italiana", "Japonesa", "Mexicana")

    var expanded by remember { mutableStateOf(false) }
    var seleccionPreferencia by remember { mutableStateOf(preferenciasCulinarias.first()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Registro de Usuario", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(16.dp))
        Text("Tipo de dieta:")
        opcionesDieta.forEach { dieta ->
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                RadioButton(
                    selected = tipoDieta == dieta,
                    onClick = { tipoDieta = dieta }
                )
                Text(dieta)
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Preferencia culinaria:")
        Box {
            OutlinedTextField(
                value = seleccionPreferencia,
                onValueChange = { },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                label = { Text("Seleccionar") }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                preferenciasCulinarias.forEach { pref ->
                    DropdownMenuItem(
                        text = { Text(pref) },
                        onClick = {
                            seleccionPreferencia = pref
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(
                checked = aceptarTerminos,
                onCheckedChange = { aceptarTerminos = it }
            )
            Text("Acepto los términos y condiciones")
        }

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { if (aceptarTerminos) onRegisterDone() },
            modifier = Modifier.fillMaxWidth(),
            enabled = aceptarTerminos
        ) {
            Text("Registrarse")
        }
    }
}
