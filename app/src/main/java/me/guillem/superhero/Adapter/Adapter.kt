package me.guillem.superhero.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.guillem.superhero.R
import me.guillem.superhero.retrofit.model.Hero

class Adapter: RecyclerView.Adapter<Adapter.VH>() {

    var context: Context? = null
    private val heroList: List<Hero>? = null


    class VH internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name: TextView? = null
        var image: ImageView? = null
        var gender: TextView? = null


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            itemView.setOnClickListener(this)
            name = itemView.findViewById(R.id.name)
            image = itemView.findViewById(R.id.image)
            gender = itemView.findViewById(R.id.gender)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_recycler_hero, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val hero: Hero? = heroList?.get(position)
        holder.name?.text = heroList?.get(position)?.name
        holder.gender?.text = heroList?.get(position)?.appearance?.gender
        holder.name?.text = heroList?.get(position)?.image?.url
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);




    }

    override fun getItemCount(): Int {
        return heroList!!.size    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

}
