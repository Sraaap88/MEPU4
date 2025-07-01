package com.moietplusultra

import android.Manifest
import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // ✅ Launcher pour demander les permissions Android 10-14
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ✅ Configuration des permissions AVANT la navigation
        setupPermissionLauncher()
        checkAndRequestPermissions()

        // ✅ Configuration de la toolbar et navigation
        setupNavigation()
        setupToolbar()
    }

    /**
     * 🔧 Configuration de la navigation (bottom nav + toolbar)
     */
    private fun setupNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav?.setupWithNavController(navController)
    }

    /**
     * ✅ NOUVEAU : Configuration de la toolbar avec menu hamburger
     */
    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        
        // ✅ Gestion des clics sur le menu hamburger
        toolbar.setOnMenuItemClickListener { menuItem ->
            handleToolbarMenuClick(menuItem)
        }
    }

    /**
     * ✅ NOUVEAU : Gestion des clics sur les items du menu hamburger
     */
    private fun handleToolbarMenuClick(menuItem: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        
        return when (menuItem.itemId) {
            R.id.progressionFragment -> {
                navController.navigate(R.id.progressionFragment)
                true
            }
            R.id.aidemoiFragment -> {
                navController.navigate(R.id.aidemoiFragment)
                true
            }
            R.id.parametresFragment -> {
                navController.navigate(R.id.parametresFragment)
                true
            }
            else -> false
        }
    }

    /**
     * 🔧 Configuration du launcher pour les permissions
     */
    private fun setupPermissionLauncher() {
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            permissions.entries.forEach { entry ->
                when (entry.key) {
                    Manifest.permission.VIBRATE -> {
                        if (entry.value) {
                            Toast.makeText(this, "✅ Vibration autorisée (Huawei P30 Pro)", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "⚠️ Vibration refusée", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    /**
     * 🔧 Vérification et demande des permissions essentielles
     */
    private fun checkAndRequestPermissions() {
        val permissionsToRequest = mutableListOf<String>()

        // ✅ VIBRATE - Important pour votre Huawei P30 Pro
        if (!isPermissionGranted(Manifest.permission.VIBRATE)) {
            permissionsToRequest.add(Manifest.permission.VIBRATE)
        }

        // ✅ Gestion des alarmes exactes (Android 12+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            checkExactAlarmPermission()
        }

        // Demander les permissions manquantes
        if (permissionsToRequest.isNotEmpty()) {
            permissionLauncher.launch(permissionsToRequest.toTypedArray())
        }
    }

    /**
     * 🔧 Vérifier si une permission est accordée
     */
    private fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * 🔧 Gestion des alarmes exactes (Android 12+) pour vos rappels
     */
    private fun checkExactAlarmPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            
            if (!alarmManager.canScheduleExactAlarms()) {
                Toast.makeText(
                    this,
                    "⚠️ Autorisez les alarmes exactes pour les rappels dans Moi et Plus Ultra",
                    Toast.LENGTH_LONG
                ).show()

                // Redirection automatique vers les paramètres après 2 secondes
                android.os.Handler(mainLooper).postDelayed({
                    try {
                        val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
                            data = Uri.parse("package:$packageName")
                        }
                        startActivity(intent)
                    } catch (e: Exception) {
                        // Si l'intent échoue, ouvrir les paramètres généraux
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.parse("package:$packageName")
                        }
                        startActivity(intent)
                    }
                }, 2000)
            }
        }
    }

    /**
     * 🔧 Méthode utilitaire pour tester la vibration (optionnel)
     * Appelez testVibration() depuis vos fragments si besoin
     */
    fun testVibration() {
        if (isPermissionGranted(Manifest.permission.VIBRATE)) {
            try {
                val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) 
                        as android.os.VibratorManager
                    vibratorManager.defaultVibrator
                } else {
                    @Suppress("DEPRECATION")
                    getSystemService(Context.VIBRATOR_SERVICE) as android.os.Vibrator
                }
                
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(
                        android.os.VibrationEffect.createOneShot(200, android.os.VibrationEffect.DEFAULT_AMPLITUDE)
                    )
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(200)
                }
                
            } catch (e: Exception) {
                Toast.makeText(this, "❌ Erreur vibration: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "⚠️ Permission vibration manquante", Toast.LENGTH_SHORT).show()
        }
    }
}