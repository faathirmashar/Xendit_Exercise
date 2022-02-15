package id.sharekom.xenditexercise.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.sharekom.xenditexercise.R
import id.sharekom.xenditexercise.databinding.ActivityMainBinding
import id.sharekom.xenditexercise.views.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpMain.adapter = ScreenSlidePagerAdapter(this)

        // ViewPager State
        binding.vpMain.setPageTransformer { _, _ ->
            when(binding.vpMain.currentItem) {
                0 -> binding.bnvMain.selectedItemId = R.id.item_home
                1 -> binding.bnvMain.selectedItemId = R.id.item_account
                else -> binding.bnvMain.selectedItemId = R.id.item_home
            }
        }

        // BottomNavigationView State
        binding.bnvMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_home -> {
                    binding.vpMain.currentItem = 0
                    true
                }
                R.id.item_account -> {
                    binding.vpMain.currentItem = 1
                    true
                }
                else -> {
                    binding.vpMain.currentItem = 0
                    true
                }
            }
        }
    }

    class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> HomeFragment()
                1 -> AccountFragment()
                else -> HomeFragment()
            }
        }
    }

    companion object {
        const val NUM_PAGES = 2
    }
}