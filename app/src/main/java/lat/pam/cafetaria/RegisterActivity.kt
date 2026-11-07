package lat.pam.cafetaria

import lat.pam.cafetaria.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNamaLengkap = findViewById<EditText>(R.id.etNamaLengkapReg)
        val etUsername = findViewById<EditText>(R.id.etUsernameReg)
        val etPassword = findViewById<EditText>(R.id.etPasswordReg)
        val btnRegister = findViewById<Button>(R.id.btnRegisterSubmit)

        btnRegister.setOnClickListener {
            val nama = etNamaLengkap.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (nama.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Registrasi Berhasil, Halo $nama!", Toast.LENGTH_SHORT).show()

                // Setelah register berhasil, arahkan ke halaman Home utama
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USER_NAME", nama)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}