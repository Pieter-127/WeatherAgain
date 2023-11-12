package com.pieterv.weatheragain.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.pieterv.weatheragain.R
import com.pieterv.weatheragain.presentation.components.StandardAlert
import com.pieterv.weatheragain.presentation.navigation.Navigation
import com.pieterv.weatheragain.presentation.ui.theme.WeatherAgainTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions: Map<String, Boolean> ->
            if (permissions.all { it.value }) {
                showUI()
            } else {
                permissionRequired()
            }
        }

        if (arePermissionsGranted()) {
            showUI()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    private fun arePermissionsGranted(): Boolean {
        val context = this
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun showUI() {
        setContent {
            WeatherAgainTheme {
                Navigation()
            }
        }
    }


    private fun permissionRequired() {
        setContent {
            WeatherAgainTheme {
                StandardAlert(getString(R.string.permissions_required),
                    getString(R.string.please_grant_the_required_permissions),
                    getString(R.string.okay), onDismiss = {
                        this.finish()
                    }, onConfirm = {

                    })
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        WeatherAgainTheme {
            Navigation()
        }
    }
}