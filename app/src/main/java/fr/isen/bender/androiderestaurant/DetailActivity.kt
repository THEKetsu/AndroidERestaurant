package fr.isen.bender.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import  fr.isen.bender.androiderestaurant.model.Items
import fr.isen.bender.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.bender.androiderestaurant.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: DetailActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        val item = intent.getSerializableExtra("dish") as Items
    }
}