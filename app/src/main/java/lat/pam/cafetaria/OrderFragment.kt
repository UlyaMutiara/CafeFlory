package lat.pam.cafetaria

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val etNama = view.findViewById<EditText>(R.id.etNamaOrder)
        val etAlamat = view.findViewById<EditText>(R.id.etAlamatOrder)
        val etPatokan = view.findViewById<EditText>(R.id.etPatokanOrder)
        val btnOrderKirim = view.findViewById<Button>(R.id.btnOrderKirim)

        val currentNama = (activity as? HomeActivity)?.currentUserName ?: ""
        if (currentNama.isNotEmpty()) {
            etNama.setText(currentNama)
        }

        btnOrderKirim.setOnClickListener {
            val nama = etNama.text.toString()
            val alamat = etAlamat.text.toString()
            val patokan = etPatokan.text.toString()

            if (nama.isNotEmpty() && alamat.isNotEmpty() && patokan.isNotEmpty()) {
                Toast.makeText(requireContext(), "Pesanan berhasil dikirim ke alamat $nama!", Toast.LENGTH_LONG).show()

                val intent = Intent(requireContext(), OrderSuccessActivity::class.java)
                intent.putExtra("USER_NAME", nama)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Mohon lengkapi semua data alamat!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
