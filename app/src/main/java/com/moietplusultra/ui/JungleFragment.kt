package com.moietplusultra.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.adapter.PlanteAdapter
import com.moietplusultra.data.PlanteManager

class JungleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_jungle, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewPlantes)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = PlanteAdapter(PlanteManager.getPlantes(requireContext()))

        return view
    }
}
