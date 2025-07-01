package com.moietplusultra.data

import android.content.Context
import com.moietplusultra.R
import com.moietplusultra.models.Plante

object PlanteManager {
    fun getPlantes(context: Context): List<Plante> {
        return listOf(
            Plante("Fleur du matin", R.drawable.ic_plante_naissante, "naissante", 1),
            Plante("Rose étoilée", R.drawable.ic_plante_fleurie, "fleurie", 3),
            Plante("Mystica", R.drawable.ic_plante_mystique, "rare", 0)
        )
    }
}
