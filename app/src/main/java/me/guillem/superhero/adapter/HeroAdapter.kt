package me.guillem.superhero.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.guillem.superhero.R
import me.guillem.superhero.retrofit.model.ProfileModel
import me.guillem.superhero.retrofit.model.ResultModel
import me.guillem.superhero.retrofit.model.SuperHeroModel
import java.util.ArrayList

class HeroAdapter: RecyclerView.Adapter<VH>() {

    private var superheroList = emptyList<ProfileModel>()
    private lateinit var context: Context
    var intent: Intent? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_hero, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.name.text = superheroList[position].name
        holder.gender.text = superheroList[position].name
        Picasso.get().load(superheroList[position].image.url).into(holder.image);

    }

    fun setData(newList: ProfileModel, context: Context){
        superheroList = listOf(newList)
        this.context = context
        notifyDataSetChanged()
    }


}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
         val name: TextView = itemView.findViewById(R.id.name)
         val image: ImageView = itemView.findViewById(R.id.image)
         val gender: TextView = itemView.findViewById(R.id.gender)

}

