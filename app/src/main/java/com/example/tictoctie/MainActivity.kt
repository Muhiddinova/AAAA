package com.example.tictoctie

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tictoctie.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    private val TAG="MainActivity"

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var lastBackPressed: Long = 0
    var mediaPlayer: MediaPlayer? = null


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
                    val intent= Intent()
                    intent.action=Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.arcsys.t")
                    intent.type="text/plain"
                    startActivity(Intent.createChooser(intent,"Share To:"))
                }
                R.id.info -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START, true)
                    navController.navigate(R.id.infoFragment)

                }

            }
            true
        }

    }

  private   fun startSound() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.click);
        }
        mediaPlayer?.start()


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

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStart() {
        super.onStart()
        startSound()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.start()
    }




}