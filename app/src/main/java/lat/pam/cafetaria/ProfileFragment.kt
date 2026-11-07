package lat.pam.cafetaria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val tvProfileHalo = view.findViewById<TextView>(R.id.tvProfileHalo)
        val etProfileNama = view.findViewById<EditText>(R.id.etProfileNama)
        val btnProfileSave = view.findViewById<Button>(R.id.btnProfileSave)

        val homeActivity = activity as? HomeActivity
        val currentNama = homeActivity?.currentUserName ?: "Kustomer"

        tvProfileHalo.text = "Halo $currentNama,"
        etProfileNama.setText(currentNama)

        btnProfileSave.setOnClickListener {
            val updatedName = etProfileNama.text.toString()
            if (updatedName.isNotEmpty()) {
                Toast.makeText(requireContext(), "Profile berhasil diperbarui!", Toast.LENGTH_SHORT).show()
                tvProfileHalo.text = "Halo $updatedName,"
                homeActivity?.currentUserName = updatedName
            } else {
                Toast.makeText(requireContext(), "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
