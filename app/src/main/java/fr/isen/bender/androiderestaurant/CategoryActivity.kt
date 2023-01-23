package fr.isen.bender.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bender.androiderestaurant.model.DataResult
import bender.androiderestaurant.model.Items
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.bender.androiderestaurant.databinding.ActivityCategoryBinding
import org.json.JSONObject
class CategoryActivity : AppCompatActivity() {
    private lateinit var category: String
    private lateinit var binding: ActivityCategoryBinding
    private var itemsList = ArrayList<Items>()
    private lateinit var CategoryAdapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = intent.getStringExtra("categoryName") ?: ""
        this.title=category

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root

        val menuName = intent.getStringExtra("categoryName") ?: ""
        val menuList = intent.getStringArrayListExtra("List_Meal")
        setContentView(view)
        if (menuList != null) {
            supportActionBar?.title = menuName

            CategoryAdapter = CategoryAdapter(itemsList) {
                val intent = Intent(this, CategoryActivity::class.java)
                intent.putExtra("categoryName", "Entrées")
                startActivity(intent)
            }

        }
        val recycler = findViewById<RecyclerView>(R.id.categoryList)
        recycler.layoutManager = LinearLayoutManager(this)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(view)
        recycler.adapter = CategoryAdapter(arrayListOf()) {
        }
        loadDishesFromAPI()
    }


private fun loadDishesFromAPI() {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, {
                Log.w("CategoryActivity", "response: $it")
                handleAPI(it.toString())
            }, {error ->
                Log.e("CategoryActivity", "Error with the request: $error")
                //afficher un message d'erreur à l'utilisateur ou gérer l'erreur de manière appropriée
            }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }
    private fun handleAPI(data: String) {
        val dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategoryFiltered = dishesResult.data.firstOrNull { it.nameFr == category }
        val adapter = binding.categoryList.adapter as CategoryAdapter
        adapter.refreshList(dishCategoryFiltered?.items as ArrayList<Items>)
    }
}


