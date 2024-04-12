package com.example.eni_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.eni_shop.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<FloatingActionButton>(R.id.fabToAddArticle).setOnClickListener {
            Intent(this, AddArticleActivity::class.java).also {
                startActivity(it)
            }
        }

        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")

        if(title != null && price != null){
            Snackbar.make(
                findViewById<FloatingActionButton>(R.id.fabToAddArticle),
                "Vous venez de créér ${title} pour un montant de ${price} €",
                Snackbar.LENGTH_LONG
            ).show()
        }

    }
}