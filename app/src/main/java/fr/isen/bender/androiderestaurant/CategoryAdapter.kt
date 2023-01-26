package fr.isen.bender.androiderestaurant
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import  fr.isen.bender.androiderestaurant.model.Items
import com.squareup.picasso.Picasso
import fr.isen.bender.androiderestaurant.model.Ingredients

class CategoryAdapter(
    private var dishes: List<Items>,
    private val clickListener: (Items) -> Unit)
    :RecyclerView.Adapter<CategoryAdapter.MyViewHolder>(){
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cellNone : TextView = view.findViewById(R.id.cellNone)
        val cellPicture : ImageView = view.findViewById(R.id.cellPicture)
        val cellPrice : TextView = view.findViewById(R.id.cellPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        println("Création du View Holder : "+viewType)
        println("Parent :"+parent)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cell2, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dish = dishes[position]
        holder.cellNone.text = dish.nameFr
        holder.cellPrice.text=dish.prices[0].price
        println("\n \n")
        println("Information :"+dish)
        println("Nom : "+dish.nameFr)
        println("Prix: "+dish.prices[0].price)
        println("\n \n")
        val firstImage = dish.images[0]
        if (firstImage.isNotEmpty()){
            Picasso.get().load(firstImage).into(holder.cellPicture);
        }
        println("Flag avant détail \n")
        holder.itemView.setOnClickListener{
            println("Je clique sur la view"+holder+"plat"+dish)
            clickListener(dish)
        }
    }
    override fun getItemCount(): Int = dishes.size


    fun refreshList(dishesFromAPI: List<Items>) {
        dishes = dishesFromAPI
        println("Total Nombre d'élements :"+getItemCount())
        println("Tout les plats :"+dishes)
        notifyDataSetChanged()
    }
}

