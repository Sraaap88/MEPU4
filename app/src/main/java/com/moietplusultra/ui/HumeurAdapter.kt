package com.moietplusultra.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.models.Humeur
import com.moietplusultra.models.Routine

class HumeurAdapter(private val humeurs: List<Humeur>) :
    RecyclerView.Adapter<HumeurAdapter.HumeurViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumeurViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_humeur, parent, false)
        return HumeurViewHolder(view)
    }

    override fun onBindViewHolder(holder: HumeurViewHolder, position: Int) {
        val (emoji, date) = humeurs[position]
        holder.humeurEmoji.text = emoji
        holder.humeurDate.text = date
    }

    override fun getItemCount(): Int = humeurs.size

    class HumeurViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val humeurEmoji: TextView = itemView.findViewById(R.id.emoticoneHumeur)
        val humeurDate: TextView = itemView.findViewById(R.id.dateHumeur)
    }
}