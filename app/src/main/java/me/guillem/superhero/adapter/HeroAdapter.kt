package me.guillem.superhero.adapter
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.guillem.superhero.R
import me.guillem.superhero.retrofit.model.ProfileModel

class HeroAdapter: RecyclerView.Adapter<VH>() {

    private var superheroList = emptyList<ProfileModel>()
    private lateinit var context: Context
    var intent: Intent? = null
    var isEnable = false




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

        holder.info.text = superheroList[position].work.occupation

        holder.weight.text = superheroList[position].appearance.weight.last()
        holder.heigh.text = superheroList[position].appearance.height.last()
        holder.race.text = superheroList[position].appearance.race


        holder.power.text = superheroList[position].powerstats.power
        holder.strength.text = superheroList[position].powerstats.strength
        holder.intelligence.text = superheroList[position].powerstats.intelligence
        holder.speed.text = superheroList[position].powerstats.speed

        holder.star.setOnClickListener(View.OnClickListener {view ->
            if (isEnable){
                holder.star.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.star_click));
            }else{
                holder.star.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.star_noclick));
            }
            isEnable = !isEnable;

        })




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
    val info: TextView = itemView.findViewById(R.id.info)
    val weight: TextView = itemView.findViewById(R.id.weight)
    val heigh: TextView = itemView.findViewById(R.id.heigh)
    val race: TextView = itemView.findViewById(R.id.race)

    val speed: TextView = itemView.findViewById(R.id.speed)
    val intelligence: TextView = itemView.findViewById(R.id.intelligence)
    val strength: TextView = itemView.findViewById(R.id.strength)
    val power: TextView = itemView.findViewById(R.id.power)

    val star: ImageButton = itemView.findViewById(R.id.star)






}

