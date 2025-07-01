package com.moietplusultra.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.adapter.ProgressionAdapter
import com.moietplusultra.utils.DataManager

class ProgressionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_progression, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.listeHumeurs)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProgressionAdapter(DataManager.getHumeurs(requireContext()))

        return view
    }
}
