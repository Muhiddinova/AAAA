package com.example.tictoctie

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tictoctie.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var lastBackPressed: Long = 0
    private var mediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(toolbar)
        val navHost = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHost.navController

        toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START, true)

        }
        binding.navView.setNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.settings -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START, true)
                    navController.navigate(R.id.settingsFragment)

                }
                R.id.share -> {
                }
                R.id.info -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START, true)
                    navController.navigate(R.id.infoFragment)

                }
            }
            true
        }

    }


    override fun onBackPressed() {


        if (navController.currentDestination?.id == R.id.mainFragment) {
            if (lastBackPressed + 2000 >= System.currentTimeMillis()) {
                finishAffinity()
            } else {
                lastBackPressed = System.currentTimeMillis()
                Toast.makeText(this, "Chiqish uchun yana bir marta bosing", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            super.onBackPressed()
        }
    }

}