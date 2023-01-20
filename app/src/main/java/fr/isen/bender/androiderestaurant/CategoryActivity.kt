package fr.isen.bender.androiderestaurant
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonObject
import fr.isen.bender.androiderestaurant.model.DataResult
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


        /*
        *         val entree: Button = findViewById(R.id.Entree)
        val plat: Button = findViewById(R.id.Plat)
        val dessert: Button = findViewById(R.id.Dessert)
        entree.setOnClickListener {
            //rediriger vers la categorie
            supportActionBar?.setTitle("Entree")
        }

        plat.setOnClickListener {
            supportActionBar?.setTitle("Plat")
            //rediriger vers la categorie
        }
        dessert.setOnClickListener {
            supportActionBar?.setTitle("Dessert")
            //rediriger vers la categorie
        }
*/


private fun loadDishesFromAPI(){
    val url = "http://test.api.catering.bluecodegames.com/menu\n"
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


    private fun handleAPI(data: String){
        var dishesResult = Gson.fromJson(data, DataResult::class.java)
        var dishCategoryFiltered = dishesResult.data.firstOrNull{it.nameFr=category}
        var adapter = binding.categoryList.adapter as CategoryAdapter
        adapter.refreshList(dishCategoryFiltered?.items?.map{it.nameFr}as ArrayList<String>)
    }
}


