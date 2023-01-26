package fr.isen.bender.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import  fr.isen.bender.androiderestaurant.model.Items
import fr.isen.bender.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.bender.androiderestaurant.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: DetailActivityBinding
    private lateinit var Item: Items
    private lateinit var name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Detail Activity :")
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Item = intent.getSerializableExtra("Detail") as Items
        name = Item.nameFr.toString()
        val actionBar = supportActionBar
        actionBar?.title = name
        val ingredients = Item.ingredients
        if (Item.ingredients.isNotEmpty()){
            val ingredientsString = java.lang.StringBuilder()
            ingredients.forEach { ingredients ->
                ingredientsString.append(ingredients.nameFr)
                ingredientsString.append("\n")
            }
            binding.Ingredients.text = ingredientsString
        }


        val prix = Item.prices
        val priceString = java.lang.StringBuilder()
        val priceunique = Item.prices[0].price?.toDouble()
        /*Add Button */
        var addition = 0
        val number = addition * priceunique!!
        binding.addButton.setOnClickListener {
            addition++
            binding.Quantity.text =Editable.Factory.getInstance().newEditable(addition.toString())

            if (Item.prices.isNotEmpty()) {
                prix.forEach { prix ->
                    priceString.append(prix.price)
                    priceString.append("$")
                }
                val number = addition * priceunique!!
                binding.TotalPrice.text = number.toString()
            }
        }

        /*Sub Button */
        binding.SubButton.setOnClickListener {
            addition--
            binding.Quantity.setText(
                Editable.Factory.getInstance().newEditable(addition.toString())
            )
            val number = addition * priceunique!!
            binding.TotalPrice.text = number.toString()
        }
    }
}