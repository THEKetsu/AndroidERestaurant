package fr.isen.bender.androiderestaurant

import android.os.Bundle
import android.view.Window
import android.widget.Button
import Gson
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonObject
import fr.isen.bender.androiderestaurant.model.DataResult

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding =
        private lateinit var category =



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

private fun loadDishesFromAPI(){
    val url = ""
    val jsonObject = JSONObject()
    jsonObject.put("id_shop","1")
    val jsonRequest=JsonObjectRequest(
        Request.Method.POST,url,JsonObject, {
            Log.w("CategoryActivity", "response: $it")
            handleAPIData(it.toString())
        },{
            Log.w("CategoryActivity")
        }
    )
    Volley.newRequestQueue(this).add(jsonRequest)
}



    /* val entree: Button = findViewById(R.id.Entree)
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
        }*/

    }
    private fun handleAPI(data: String){
        var dishesResult = Gson.fromJson(data, DataResult::class.java)
        var dishCategoryFiltered = dishesResult.data.firstOrNull{it.nameFr=category}
        var adapter = binding.categoryList.adapter as CategoryAdapter
        adapter.refreshList(dishCategoryFiltered?.items?.map{it.nameFr}as ArrayList<String>)
    }
}


