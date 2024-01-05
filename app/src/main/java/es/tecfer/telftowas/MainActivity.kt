package es.tecfer.telftowas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phoneNumberEditText: EditText = findViewById(R.id.phoneNumberEditText)
        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val phoneNumber = phoneNumberEditText.text.toString().trim()

            if (phoneNumber.isNotEmpty()) {
                // Construir el enlace web con el contenido del EditText
                val webUrl = "https://wa.me/$phoneNumber"

                // Crear un Intent para abrir el enlace web
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))

                // Verificar si hay aplicaciones que pueden manejar este intent
                if (intent.resolveActivity(packageManager) != null) {
                    // Si hay una aplicación, iniciar la actividad
                    startActivity(intent)
                } else {
                    // Manejar el caso en el que no haya aplicaciones para manejar el intent
                    // Puedes mostrar un mensaje o realizar alguna otra acción
                }
            }
        }
    }
}
