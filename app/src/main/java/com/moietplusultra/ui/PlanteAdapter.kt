package com.moietplusultra.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.models.Plante

class PlanteAdapter(private val plantes: List<Plante>) :
    RecyclerView.Adapter<PlanteAdapter.PlanteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plante, parent, false)
        return PlanteViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanteViewHolder, position: Int) {
        val plante = plantes[position]
        holder.nom.text = plante.nom
        holder.image.setImageResource(plante.imageResId)
    }

    override fun getItemCount(): Int = plantes.size

    class PlanteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nom: TextView = itemView.findViewById(R.id.planteNom)
        val image: ImageView = itemView.findViewById(R.id.planteImage)
    }
}
