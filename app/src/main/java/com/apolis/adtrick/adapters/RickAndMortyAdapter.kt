package com.apolis.adtrick.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolis.adtrick.R
import com.apolis.adtrick.models.RickAndMortyCharacters
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rick_and_morty_adapter.view.*

class RickAndMortyAdapter(val context: Context, val results: List<RickAndMortyCharacters>): RecyclerView.Adapter<RickAndMortyAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(characters: RickAndMortyCharacters){
            itemView.name.text = characters.name
            itemView.status_and_species.text = characters.species + " : " + characters.status
            Glide.with(itemView)
                .load(characters.image)
                .into(itemView.image)

            itemView.setOnClickListener {
                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setMessage("${characters.location.name}")
                alertDialog.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rick_and_morty_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = results[position]
        holder.bindView(characters)

    }

    override fun getItemCount(): Int {
       return results.size
    }
}