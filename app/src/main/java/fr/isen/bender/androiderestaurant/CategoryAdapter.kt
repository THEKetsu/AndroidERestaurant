package fr.isen.bender.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.Locale.Category

class CategoryAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MyViewHolder(binding)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(viewModel.items[position])
        }
    override fun getItemCount(): Int = dishes.size
    fun refreshList(dishesFromAPI: List<String>) {
        dishes = dishesFromAPI
        notifyDataSetChanged()
    }
}