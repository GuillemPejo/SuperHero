package me.guillem.superhero.adapter
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.guillem.superhero.R
import me.guillem.superhero.retrofit.model.ProfileModel

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
        holder.real_name.text = superheroList[position].biography.full_name

        holder.gender.setImageResource(getGender(superheroList[position].appearance.gender))
        //holder.gender.text = superheroList[position].name
        Picasso.get().load(superheroList[position].image.url).into(holder.image);
        //Picasso.get().load(R.drawable.female).into(holder.gender)

    }

    fun setData(newList: ProfileModel, context: Context){
        superheroList = listOf(newList)
        this.context = context
        notifyDataSetChanged()
    }


    private fun getGender(gender: String): Int {
        if (gender == "Male") {
            return R.drawable.male
        } else if (gender == "Female") {
            return R.drawable.female
        }
        return R.drawable.idk
    }



}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
    val name: TextView = itemView.findViewById(R.id.name)
    val real_name: TextView = itemView.findViewById(R.id.real_name)
    val image: ImageView = itemView.findViewById(R.id.image)
    val gender: ImageView = itemView.findViewById(R.id.gender)

}

