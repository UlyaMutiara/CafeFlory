package lat.pam.cafetaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_option)

        // Tombol menuju halaman Register (Layer 4)
        findViewById<Button>(R.id.btnOptionRegister).setOnClickListener {
            // Nanti kita arahkan ke RegisterActivity
        }

        // Tombol menuju halaman Login (Layer 3)
        findViewById<Button>(R.id.btnOptionLogin).setOnClickListener {
            // Nanti kita arahkan ke LoginActivity
        }

        findViewById<Button>(R.id.btnOptionLogin).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnOptionRegister).setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}