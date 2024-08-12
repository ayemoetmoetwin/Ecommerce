package com.ammw.ecommercemobileapp.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ammw.ecommercemobileapp.R
import com.ammw.ecommercemobileapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController:NavController

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment

        navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.mobile_navigation)

        navController.graph = navGraph

        navController.navigate(R.id.homeFragment)
        binding.apply {
            ivMenuHomeMount.visibility = View.VISIBLE
            ivMenuBookmarkMount.visibility = View.INVISIBLE
            ivMenuSearchMount.visibility = View.INVISIBLE
            ivMenuCartMount.visibility = View.INVISIBLE
        }

        clickItem()
    }

    private fun clickItem() {
        binding.apply {
            ivMenuHome.setOnClickListener {
                ivMenuHomeMount.visibility = View.VISIBLE
                ivMenuBookmarkMount.visibility = View.INVISIBLE
                ivMenuSearchMount.visibility = View.INVISIBLE
                ivMenuCartMount.visibility = View.INVISIBLE
                navController.navigate(R.id.homeFragment)
            }
            ivMenuCart.setOnClickListener {
                ivMenuHomeMount.visibility = View.INVISIBLE
                ivMenuBookmarkMount.visibility = View.INVISIBLE
                ivMenuSearchMount.visibility = View.INVISIBLE
                ivMenuCartMount.visibility = View.VISIBLE
                navController.navigate(R.id.cartFragment)
            }
            ivMenuBookmark.setOnClickListener {
                ivMenuHomeMount.visibility = View.INVISIBLE
                ivMenuBookmarkMount.visibility = View.VISIBLE
                ivMenuSearchMount.visibility = View.INVISIBLE
                ivMenuCartMount.visibility = View.INVISIBLE
                navController.navigate(R.id.bookmarkFragment)
            }
            ivMenuSearch.setOnClickListener {
                ivMenuHomeMount.visibility = View.INVISIBLE
                ivMenuBookmarkMount.visibility = View.INVISIBLE
                ivMenuSearchMount.visibility = View.VISIBLE
                ivMenuCartMount.visibility = View.INVISIBLE
                navController.navigate(R.id.searchFragment)
            }
        }
    }
}