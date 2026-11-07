package lat.pam.cafetaria

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {

    var currentUserName: String = "Kustomer"

    private val homeFragment = HomeFragment()
    private val orderFragment = OrderFragment()
    private val profileFragment = ProfileFragment()
    private var activeFragment: Fragment = homeFragment

    private lateinit var navHomeTab: LinearLayout
    private lateinit var navOrderTab: LinearLayout
    private lateinit var navProfileTab: LinearLayout

    private lateinit var tvNavHome: TextView
    private lateinit var tvNavOrder: TextView
    private lateinit var tvNavProfile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        currentUserName = intent.getStringExtra("USER_NAME") ?: "Kustomer"

        navHomeTab = findViewById(R.id.navHome)
        navOrderTab = findViewById(R.id.navOrder)
        navProfileTab = findViewById(R.id.navProfile)

        tvNavHome = findViewById(R.id.tvNavHome)
        tvNavOrder = findViewById(R.id.tvNavOrder)
        tvNavProfile = findViewById(R.id.tvNavProfile)

        // Setup Bottom Nav click listeners
        navHomeTab.setOnClickListener {
            switchTab(0)
        }
        navOrderTab.setOnClickListener {
            switchTab(1)
        }
        navProfileTab.setOnClickListener {
            switchTab(2)
        }

        // Add all fragments once and show Home initially
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, profileFragment, "PROFILE")
                .hide(profileFragment)
                .add(R.id.fragmentContainer, orderFragment, "ORDER")
                .hide(orderFragment)
                .add(R.id.fragmentContainer, homeFragment, "HOME")
                .commit()
            activeFragment = homeFragment
            updateBottomNavUi(0)
        }
    }

    private fun switchTab(tabIndex: Int) {
        val targetFragment = when (tabIndex) {
            0 -> homeFragment
            1 -> orderFragment
            2 -> profileFragment
            else -> homeFragment
        }

        if (activeFragment != targetFragment) {
            supportFragmentManager.beginTransaction()
                .hide(activeFragment)
                .show(targetFragment)
                .commit()
            activeFragment = targetFragment
        }

        updateBottomNavUi(tabIndex)
    }

    private fun updateBottomNavUi(activeIndex: Int) {
        // Reset all tabs
        navHomeTab.background = null
        navOrderTab.background = null
        navProfileTab.background = null

        tvNavHome.setTextColor(Color.parseColor("#7A9A8B"))
        tvNavOrder.setTextColor(Color.parseColor("#7A9A8B"))
        tvNavProfile.setTextColor(Color.parseColor("#7A9A8B"))

        // Set active tab
        when (activeIndex) {
            0 -> {
                navHomeTab.setBackgroundResource(R.drawable.bg_nav_active)
                tvNavHome.setTextColor(Color.parseColor("#FFFFFF"))
            }
            1 -> {
                navOrderTab.setBackgroundResource(R.drawable.bg_nav_active)
                tvNavOrder.setTextColor(Color.parseColor("#FFFFFF"))
            }
            2 -> {
                navProfileTab.setBackgroundResource(R.drawable.bg_nav_active)
                tvNavProfile.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }
}
