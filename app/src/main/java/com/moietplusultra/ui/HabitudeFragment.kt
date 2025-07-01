package com.moietplusultra.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.adapter.HabitudeAdapter
import com.moietplusultra.utils.DataManager

class HabitudeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_habitude, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.listeHabitudes)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HabitudeAdapter(DataManager.getHabitudes(requireContext()))

        return view
    }
}
