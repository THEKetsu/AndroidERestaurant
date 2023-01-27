package fr.isen.bender.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.bender.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.bender.androiderestaurant.model.DataResult
import fr.isen.bender.androiderestaurant.model.Items
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {
    private lateinit var category: String
    private lateinit var binding: ActivityCategoryBinding
    private var itemsList = ArrayList<Items>()
    private lateinit var myCategoryAdapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        category = intent.getStringExtra("category") ?: ""
        this.title = category
        val view = binding.root
        setContentView(view)
        binding.categoryList.layoutManager = LinearLayoutManager(this)
        binding.categoryList.adapter = CategoryAdapter(arrayListOf()) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("Detail", it)
            startActivity(intent)
        }
        loadDishesFromAPI()
    }

private fun loadDishesFromAPI() {
    Volley.newRequestQueue(this)
    println("function loadDishesFromAPI")
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, {
                Log.w("CategoryActivity", "response: $it")
                handleAPI(it.toString())
            }, {error ->
                Log.e("CategoryActivity", "Error with the request: $error")
            }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }
    private fun handleAPI(data: String) {
        println("function handleAPI")
        val dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategoryFiltered = dishesResult.data.firstOrNull { it.nameFr == category }
        println("Dish: "+dishCategoryFiltered)
        val adapter = binding.categoryList.adapter as CategoryAdapter
        adapter.refreshList(dishCategoryFiltered?.items as ArrayList<Items>)
    }
}


