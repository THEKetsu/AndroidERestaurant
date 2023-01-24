package fr.isen.bender.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.isen.bender.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Init
        val intent = Intent(this@HomeActivity, CategoryActivity::class.java)
        val entree: Button = findViewById(R.id.Entree)
        val plat: Button = findViewById(R.id.Plat)
        val dessert: Button = findViewById(R.id.Dessert)

        binding.Entree.setOnClickListener {
            val toast = Toast.makeText(this, "Entree", Toast.LENGTH_SHORT)
            toast.show()
            val mealList = resources.getStringArray(R.array.e_list).toList() as ArrayList<String>
            intent.putExtra("category", getString(R.string.starters))
            startActivity(intent)
        }
        binding.Plat.setOnClickListener {
            val toast = Toast.makeText(this, "Plat", Toast.LENGTH_SHORT)
            val mealList = resources.getStringArray(R.array.p_list).toList() as ArrayList<String>
            toast.show()
            intent.putExtra("category", getString(R.string.dishes))
            startActivity(intent)
        }
        binding.Dessert.setOnClickListener {
            val toast = Toast.makeText(this, "Dessert", Toast.LENGTH_SHORT)
            val mealList = resources.getStringArray(R.array.d_list).toList() as ArrayList<String>
            toast.show()
            intent.putExtra("category", getString(R.string.desserts))
            startActivity(intent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "L'activité Home a été détruite")
    }
}


