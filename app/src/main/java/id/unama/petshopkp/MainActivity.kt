package id.unama.petshopkp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.unama.petshopkp.adapter.ViewPagerAdapter
import id.unama.petshopkp.databinding.ActivityMainBinding
import id.unama.petshopkp.fragment.HomeFragment
import id.unama.petshopkp.fragment.ShoppingFragment
import id.unama.petshopkp.fragment.UserFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()

    }

    private fun setupTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(),"")
        adapter.addFragment(ShoppingFragment(),"")
        adapter.addFragment(UserFragment(),"")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_shopping)
        binding.tabs.getTabAt(2)!!.setIcon(R.drawable.ic_user)
    }
}