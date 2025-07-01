package com.moietplusultra.utils

import android.content.Context
import com.moietplusultra.data.ProgressionData

object ProgressionUtils {
    fun getHumeurs(context: Context): List<ProgressionData> {
        // Simulation de données
        return listOf(
            ProgressionData("2025-06-01", "🙂"),
            ProgressionData("2025-06-02", "😔"),
            ProgressionData("2025-06-03", "😁")
        )
    }
}
