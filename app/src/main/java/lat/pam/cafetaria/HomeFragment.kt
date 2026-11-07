package lat.pam.cafetaria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val tvHaloNama = view.findViewById<TextView>(R.id.tvHaloNama)
        val namaUser = (activity as? HomeActivity)?.currentUserName ?: "Kustomer"
        tvHaloNama.text = "Halo $namaUser,"

        // Mengisi Data 10 Menu sesuai dengan nama file di gambar
        setMenuData(view, R.id.itemMenu1, R.drawable.kopi_susu, "Kopi Susu Gula Aren", "• Espresso, susu, gula aren", "• Rp 22.000")
        setMenuData(view, R.id.itemMenu2, R.drawable.donut, "Donat Cokelat", "• Donat empuk, glaze cokelat", "• Rp 12.000")
        setMenuData(view, R.id.itemMenu3, R.drawable.sourdough, "Sourdough Loaf", "• Roti fermentasi alami", "• Rp 35.000")
        setMenuData(view, R.id.itemMenu4, R.drawable.cappuccino, "Cappuccino", "• Espresso, foam susu lembut", "• Rp 25.000")
        setMenuData(view, R.id.itemMenu5, R.drawable.matcha, "Matcha Latte", "• Matcha Jepang, susu segar", "• Rp 27.000")
        setMenuData(view, R.id.itemMenu6, R.drawable.croissant, "Croissant Butter", "• Pastry renyah mentega Prancis", "• Rp 18.000")
        setMenuData(view, R.id.itemMenu7, R.drawable.lychee_tea, "Lychee Tea", "• Teh hitam, buah leci segar", "• Rp 20.000")
        setMenuData(view, R.id.itemMenu8, R.drawable.cinnamon_roll, "Cinnamon Roll", "• Roti gulung kayu manis lembut", "• Rp 16.000")
        setMenuData(view, R.id.itemMenu9, R.drawable.americano, "Americano", "• Double shot espresso, air", "• Rp 19.000")
        setMenuData(view, R.id.itemMenu10, R.drawable.french_fries, "French Fries", "• Kentang goreng renyah gurih", "• Rp 15.000")

        return view
    }

    private fun setMenuData(rootView: View, includeId: Int, imageResId: Int, name: String, desc: String, price: String) {
        val root = rootView.findViewById<View>(includeId)
        root?.findViewById<TextView>(R.id.tvNamaMenu)?.text = name
        root?.findViewById<TextView>(R.id.tvDeskripsiMenu)?.text = desc
        root?.findViewById<TextView>(R.id.tvHargaMenu)?.text = price
        root?.findViewById<ImageView>(R.id.ivMenuPhoto)?.setImageResource(imageResId)
    }
}
