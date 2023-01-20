package fr.isen.bender.androiderestaurant

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject
class CategoryActivity : AppCompatActivity() {
    private lateinit var category: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        category = intent.getStringExtra("category") ?: ""
        val recycler = findViewById<RecyclerView>(R.id.categoryList)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CategoryAdapter(arrayListOf()) {

        }

        //loadDishesFromAPI()
    }
/*
* private fun loadDishesFromAPI() {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, {
                Log.w("CategoryActivity", "response: $it")
                handleAPIData(it.toString())
            }, {
                Log.w("CategoryActivity")
            }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPI(data: String) {
        val dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategoryFiltered = dishesResult.data.firstOrNull { it.nameFr == category }
        val adapter = recycler.adapter as CategoryAdapter
        adapter.refreshList(dishCategoryFiltered?.items?.map { it.nameFr } ?: listOf())
    }*/

}


