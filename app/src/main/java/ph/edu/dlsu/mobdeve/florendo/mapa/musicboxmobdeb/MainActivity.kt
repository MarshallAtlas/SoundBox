package ph.edu.dlsu.mobdeve.florendo.mapa.musicboxmobdeb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import ph.edu.dlsu.mobdeve.florendo.mapa.musicboxmobdeb.fragments.account_frag
import ph.edu.dlsu.mobdeve.florendo.mapa.musicboxmobdeb.fragments.dash_frag
import ph.edu.dlsu.mobdeve.florendo.mapa.musicboxmobdeb.fragments.search_frag


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dash)
        val navView: NavigationView = findViewById(R.id.bottom_nav)


        val dashFragment = dash_frag()
        val searchFragment = search_frag()
        val accountFragment = account_frag()

        makeCurrentFragment(dashFragment)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dash -> makeCurrentFragment(dashFragment)
                R.id.nav_account -> makeCurrentFragment(accountFragment)
                R.id.nav_search -> makeCurrentFragment(searchFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
}