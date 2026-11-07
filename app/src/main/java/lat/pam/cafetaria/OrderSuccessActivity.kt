package lat.pam.cafetaria

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_success) // Menghubungkan ke file XML yang baru saja kamu buat

        val tvKonfirmasiNama = findViewById<TextView>(R.id.tvKonfirmasiNama)
        val btnSelesaiOk = findViewById<Button>(R.id.btnSelesaiOk)

        // Menerima nama pengguna yang dikirim dari halaman Order sebelumnya
        val namaUser = intent.getStringExtra("USER_NAME") ?: "Kustomer"
        tvKonfirmasiNama.text = "Halo $namaUser,"

        // Ketika tombol "Oke" ditekan, kembali ke halaman Home dengan bersih
        btnSelesaiOk.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("USER_NAME", namaUser)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}