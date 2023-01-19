package fr.isen.bender.androiderestaurant

import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        // Init
        val entree: Button = findViewById(R.id.Entree)
        val plat: Button = findViewById(R.id.Plat)
        val dessert: Button = findViewById(R.id.Dessert)
        val w: Window = window
        entree.setOnClickListener {
            setContentView(R.layout.entree)
            w.setTitle("ENTREE")
        }

        plat.setOnClickListener {
            setContentView(R.layout.plat)
            w.setTitle("PLAT")
        }
        dessert.setOnClickListener {
            setContentView(R.layout.sortie)
            w.setTitle("DESSERT")
        }
    }
}
