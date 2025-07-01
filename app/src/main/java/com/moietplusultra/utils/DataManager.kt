package com.moietplusultra.utils

import android.content.Context
import android.content.SharedPreferences
import com.moietplusultra.models.Humeur
import com.moietplusultra.models.Habitude
import com.moietplusultra.models.Routine
import com.moietplusultra.models.Plante

object DataManager {
    private const val PREFS_NAME = "MoiEtPlusUltraPrefs"

    fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveString(context: Context, key: String, value: String) {
        getPrefs(context).edit().putString(key, value).apply()
    }

    fun getString(context: Context, key: String): String? {
        return getPrefs(context).getString(key, null)
    }

    fun saveBoolean(context: Context, key: String, value: Boolean) {
        getPrefs(context).edit().putBoolean(key, value).apply()
    }

    fun getBoolean(context: Context, key: String): Boolean {
        return getPrefs(context).getBoolean(key, false)
    }

    fun saveInt(context: Context, key: String, value: Int) {
        getPrefs(context).edit().putInt(key, value).apply()
    }

    fun getInt(context: Context, key: String): Int {
        return getPrefs(context).getInt(key, 0)
    }

    fun getHabitudes(context: Context): List<Habitude> {
        val set = getPrefs(context).getStringSet("habitudes", emptySet()) ?: return emptyList()
        return set.mapNotNull { str ->
            val parts = str.split("|")
            if (parts.size == 5) {
                try {
                    Habitude(
                        id = parts[0].toInt(),
                        title = parts[1],
                        currentStreak = parts[2].toInt(),
                        bestStreak = parts[3].toInt(),
                        isSkippedToday = parts[4].toBoolean()
                    )
                } catch (e: Exception) {
                    null
                }
            } else null
        }
    }

    fun getRoutines(context: Context): List<Routine> {
        val set = getPrefs(context).getStringSet("routines", emptySet()) ?: return emptyList()
        return set.mapNotNull { str ->
            val parts = str.split("|")
            if (parts.size == 5) {
                try {
                    Routine(
                        id = parts[0].toInt(),
                        title = parts[1],
                        isActive = parts[2].toBoolean(),
                        recurrence = parts[3],
                        memo = parts[4]
                    )
                } catch (e: Exception) {
                    null
                }
            } else null
        }
    }

    fun getHumeurs(context: Context): List<Humeur> {
        return listOf(
            Humeur(date = "2025-06-28", emoji = "😊", note = ""),
            Humeur(date = "2025-06-27", emoji = "😴", note = ""),
            Humeur(date = "2025-06-26", emoji = "🥵", note = "")
        )
    }

//    fun getHumeurs(context: Context): List<Humeur> {
//        val set = getPrefs(context).getStringSet("humeurs", emptySet()) ?: return emptyList()
//        return set.mapNotNull { str ->
//            val parts = str.split("|")
//            if (parts.size >= 3) {
//                try {
//                    Humeur(
//                        date = parts[0],
//                        emoji = parts[1],
//                        note = parts[2]
//                    )
//                } catch (e: Exception) {
//                    null
//                }
//            } else null
//        }
//    }
}