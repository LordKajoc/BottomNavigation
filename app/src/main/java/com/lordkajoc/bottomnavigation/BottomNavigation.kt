package com.lordkajoc.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.lordkajoc.bottomnavigation.databinding.ActivityBottomNavBinding

class BottomNavigation : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstFragment = FragmentPerson()
        val secondFragment = FragmentHome ()

        setCurrentFragment(firstFragment)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.person->setCurrentFragment(firstFragment)
                R.id.home-> setCurrentFragment(secondFragment)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment:Fragment): FragmentTransaction =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }
}
