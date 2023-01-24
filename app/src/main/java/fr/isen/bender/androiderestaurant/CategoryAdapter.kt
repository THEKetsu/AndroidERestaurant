package fr.isen.bender.androiderestaurant
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import  fr.isen.bender.androiderestaurant.model.Items
import com.squareup.picasso.Picasso
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cell2, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dish = dishes[position]
        holder.cellNone.text = dish.nameFr
        holder.cellPrice.text=dish.prices[0].price
        val firstImage = dish.images[0]
        if (firstImage.isNotEmpty()){
            Picasso.get().load(firstImage).into(holder.cellPicture);
        }
        holder.itemView.setOnClickListener{
            clickListener(dish)
        }
    }
    override fun getItemCount(): Int = dishes.size
    fun refreshList(dishesFromAPI: List<Items>) {
        dishes = dishesFromAPI
        println("Test :"+dishes)
        notifyDataSetChanged()
    }
}

