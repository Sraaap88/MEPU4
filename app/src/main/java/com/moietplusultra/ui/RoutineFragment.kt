package com.moietplusultra.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moietplusultra.R
import com.moietplusultra.adapter.RoutineAdapter
import com.moietplusultra.utils.DataManager

class RoutineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_routine, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.listeRoutines)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RoutineAdapter(DataManager.getRoutines(requireContext()))

        return view
    }
}
