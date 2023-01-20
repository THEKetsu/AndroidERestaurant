package fr.isen.bender.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class CategoryAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onBindViewHolder(holder:Ca)
    override fun getItemCount(): Int = dishes.size

    fun refreshList(dishesFromAPI: List<String>) {
        dishes = dishesFromAPI
        notifyDataSetChanged()
    }
}