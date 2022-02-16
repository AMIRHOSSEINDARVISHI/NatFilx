package code.with.cal.netflix.view



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import code.with.cal.netflix.R
import code.with.cal.netflix.databinding.ActivityMainBinding
import code.with.cal.netflix.fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMain = ActivityMainBinding.inflate(layoutInflater)

        fragmentIsRun(HomeFragment())

        bindingMain.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    fragmentIsRun(HomeFragment())
                    true
                }
                R.id.menu_coming_soon -> {
                    fragmentIsRun(ComingSoonFragment())
                    true
                }
                R.id.menu_favorite -> {
                    fragmentIsRun(FavoriteFragment())
                    true
                }
                R.id.menu_profile -> {
                    fragmentIsRun(RegisterProfileFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }

        setContentView(bindingMain.root)
    }

    private fun fragmentIsRun(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container_main, fragment)
            setReorderingAllowed(true)
        }
    }
}