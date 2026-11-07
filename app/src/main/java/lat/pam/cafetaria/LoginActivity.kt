package lat.pam.cafetaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.etUsernameLogin)
        val etPassword = findViewById<EditText>(R.id.etPasswordLogin)
        val btnLogin = findViewById<Button>(R.id.btnLoginSubmit)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // PERBAIKAN: Tambahkan .show() di akhir Toast
                Toast.makeText(this, "Login Berhasil, Selamat Datang $username!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USER_NAME", username)
                startActivity(intent)
                finish()
            } else {
                // PERBAIKAN: Tambahkan .show() di akhir Toast
                Toast.makeText(this, "Username dan password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}