package com.pieterv.weatheragain.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun StandardAlert(
    dialogTitle: String,
    contentText: String,
    confirmText: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        title = { Text(text = dialogTitle) },
        text = {
            Text(text = contentText)
        },
        onDismissRequest = {
            onDismiss()
        }, confirmButton = {
            Button(onClick = {
                onConfirm()
            }) {
                Text(text = confirmText)
            }
        })
}