package es.tecfer.telftowas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_phoneNumber: EditText = findViewById(R.id.et_phoneNumber)
        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val phoneNumber = et_phoneNumber.text.toString().trim()

            if (phoneNumber.isNotEmpty()) {

                val webUrl = "https://api.whatsapp.com/send/?phone=$phoneNumber"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))

                startActivity(intent)
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
