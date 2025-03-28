package com.example.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prueba.ui.theme.PruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraInterfaz(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalculadoraInterfaz(modifier: Modifier = Modifier) {
    var resultado by remember { mutableStateOf("0") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = resultado,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.End,
            fontSize = 48.sp
        )


        Row(Modifier.fillMaxWidth()) {
            BotonNumero("7") { /* Acción al presionar 7 */ }
            BotonNumero("8") { /* Acción al presionar 8 */ }
            BotonNumero("9") { /* Acción al presionar 9 */ }
            BotonOperador("/") { /* Acción al presionar / */ }
        }
        Row(Modifier.fillMaxWidth()) {
            BotonNumero("4") { /* Acción al presionar 4 */ }
            BotonNumero("5") { /* Acción al presionar 5 */ }
            BotonNumero("6") { /* Acción al presionar 6 */ }
            BotonOperador("*") { /* Acción al presionar * */ }
        }
        Row(Modifier.fillMaxWidth()) {
            BotonNumero("1") { /* Acción al presionar 1 */ }
            BotonNumero("2") { /* Acción al presionar 2 */ }
            BotonNumero("3") { /* Acción al presionar 3 */ }
            BotonOperador("-") { /* Acción al presionar - */ }
        }
        Row(Modifier.fillMaxWidth()) {
            BotonNumero("0") { /* Acción al presionar 0 */ }
            BotonOperador("+") { /* Acción al presionar + */ }
            BotonOperador("=") { /* Acción al presionar = */ }
        }
    }
}

@Composable
fun BotonNumero(numero: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
           
            .padding(4.dp)
    ){
                Text(text = numero, fontSize = 36.sp)
            }
}

@Composable
fun BotonOperador(operador: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,

    ) {
        Text(text = operador, fontSize = 36.sp)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    PruebaTheme {
        CalculadoraInterfaz()
    }
}