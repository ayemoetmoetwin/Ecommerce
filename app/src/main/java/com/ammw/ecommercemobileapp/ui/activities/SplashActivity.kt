package com.ammw.ecommercemobileapp.ui.activities

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ammw.ecommercemobileapp.R
import com.ammw.ecommercemobileapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
            overrideActivityTransition(OVERRIDE_TRANSITION_OPEN,R.anim.slide_in, R.anim.slide_out,resources.getColor(R.color.white))
            finish()
        }
    }
}