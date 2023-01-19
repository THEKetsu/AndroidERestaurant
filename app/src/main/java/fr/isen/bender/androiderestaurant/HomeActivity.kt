package fr.isen.bender.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val gameActivityIntent = Intent(this@HomeActivity, SecondActivity::class.java)
        startActivity(gameActivityIntent)
        Debug.startMethodTracing("sample")
        Debug.stopMethodTracing()

        // Init
        val entree: Button = findViewById(R.id.Entree)
        val plat: Button = findViewById(R.id.Plat)
        val dessert: Button = findViewById(R.id.Dessert)
        entree.setOnClickListener {
            val toast = Toast.makeText(this, "Entree", Toast.LENGTH_SHORT)
            toast.show()
        }

        plat.setOnClickListener {
            val toast = Toast.makeText(this, "Plat", Toast.LENGTH_SHORT)
            toast.show()
        }
        dessert.setOnClickListener {
            val toast = Toast.makeText(this, "Dessert", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}

