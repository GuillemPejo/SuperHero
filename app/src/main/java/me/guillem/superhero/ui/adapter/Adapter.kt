package me.guillem.superhero.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.guillem.superhero.R
import me.guillem.superhero.retrofit.model.Result

class Adapter(val heros: List<Result>) : RecyclerView.Adapter<VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_hero, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return heros.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        return holder.bind(heros[position])
    }

}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val name: TextView = itemView.findViewById(R.id.name)
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val gender: TextView = itemView.findViewById(R.id.gender)

        fun bind(hero: Result) {
            name.text = hero.name
            gender.text = hero.appearance.gender
            Picasso.get().load(hero.image.url).into(image);
        }
}

