package com.moietplusultra.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.models.Humeur

class ProgressionAdapter(private val humeurs: List<Humeur>) :
    RecyclerView.Adapter<ProgressionAdapter.HumeurViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumeurViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_progression_humeur, parent, false)
        return HumeurViewHolder(view)
    }

    override fun onBindViewHolder(holder: HumeurViewHolder, position: Int) {
        val humeur = humeurs[position]
        holder.date.text = humeur.date
        holder.emoji.text = humeur.emoji
    }

    override fun getItemCount(): Int = humeurs.size

    class HumeurViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.dateHumeur)
        val emoji: TextView = itemView.findViewById(R.id.emoticoneHumeur)
    }
}
