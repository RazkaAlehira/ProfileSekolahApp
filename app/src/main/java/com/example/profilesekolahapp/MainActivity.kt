package com.example.profilesekolahapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.profilesekolahapp.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val retrofit = Retrofit.Builder()
        .baseUrl("https://profilesekolahapp.firebaseio.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        binding = ActivityMainBinding.inflate(inflater)
        setContentView(binding.root)

        // Definisikan id NavHostFragment yang ada di activity_main.xml,
        // idnya itu nav_host
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment? ?: return
        val navController = host.navController

        // bottomNav itu adalah id dari bottomNavigation
        binding.bottomNav.setupWithNavController(navController)
    }
}