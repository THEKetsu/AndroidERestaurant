package fr.isen.bender.androiderestaurant.model
import com.google.gson.annotations.SerializedName

data class DataResult (
  @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()
)