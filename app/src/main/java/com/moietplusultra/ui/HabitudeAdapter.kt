package com.moietplusultra.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.models.Habitude

class HabitudeAdapter(private val habitudes: List<Habitude>) :
    RecyclerView.Adapter<HabitudeAdapter.HabitudeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitudeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_habitude, parent, false)
        return HabitudeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitudeViewHolder, position: Int) {
        val habitude = habitudes[position]
        holder.title.text = habitude.title
    }

    override fun getItemCount(): Int = habitudes.size

    class HabitudeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.texteHabitude)
    }
}
