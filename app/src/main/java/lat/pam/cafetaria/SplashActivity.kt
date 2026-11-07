package lat.pam.cafetaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menghubungkan tombol Start Now dengan ID di activity_splash.xml
        val btnStartNow = findViewById<Button>(R.id.btnStartNow)

        btnStartNow.setOnClickListener {
            // Berpindah dari SplashActivity ke halaman berikutnya (nanti kita buat Layer 2)
            val intent = Intent(this, WelcomeOptionActivity::class.java)
            startActivity(intent)
        }
    }
}
