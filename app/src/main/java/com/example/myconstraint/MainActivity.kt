package com.example.myconstraint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.myconstraint.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //  Judul Fragment / Tab
    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_text1, R.string.tab_text2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

//        Variabel Pager Adapter
        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager : ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter


        val tabs: TabLayout = findViewById(R.id.main_tab_layout)
        TabLayoutMediator(tabs,viewPager){tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

    }


}
