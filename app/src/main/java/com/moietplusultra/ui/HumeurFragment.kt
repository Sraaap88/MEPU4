package com.moietplusultra.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.ui.HumeurAdapter
import com.moietplusultra.utils.DataManager

class HumeurFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_humeur, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.listeHumeurs)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HumeurAdapter(DataManager.getHumeurs(requireContext()))

        return view
    }
}
