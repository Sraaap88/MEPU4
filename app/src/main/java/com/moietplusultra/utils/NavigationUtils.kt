package com.moietplusultra.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.moietplusultra.R

object NavigationUtils {

    fun navigateToFragment(activity: FragmentActivity, destinationId: Int, bundle: Bundle? = null) {
        val navController = activity.findNavController(R.id.nav_host_fragment)
        navController.navigate(destinationId, bundle)
    }

    fun goBack(fragment: Fragment) {
        val navController = fragment.findNavController()
        navController.popBackStack()
    }
}
