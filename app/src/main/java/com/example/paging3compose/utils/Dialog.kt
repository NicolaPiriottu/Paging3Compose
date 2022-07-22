package com.example.paging3compose.utils

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.paging3compose.R

/**
 * Created by Nicola Luigi Piriottu on 08/07/22.
 */

@Composable
fun DialogScreen(
    showDialog: Boolean,
    titleResId: Int,
    message: String,
    positiveButtonMessage: Int,
    negativeButtonMessage: Int,
    onPositiveButton: () -> Unit,
    onNegativeButton: () -> Unit,
) {

    if (showDialog) {

        AlertDialog(
            title = {
                Text(text = stringResource(id = titleResId))
            },
            text = { Text(text = message) },

            confirmButton = {
                TextButton(onClick = onPositiveButton){
                    Text(text = stringResource(id = positiveButtonMessage))
                }
            },

            dismissButton = {
                TextButton(onClick = onNegativeButton){
                    Text(text = stringResource(id = negativeButtonMessage))
                }
            },

            onDismissRequest = { onNegativeButton }
        )


        /*  AlertDialog(
              title = { Text(text = stringResource(id = titleResId)) },
              text = { Text(text = message) },
              confirmButton = {
                  Button(
                      onClick = { onPositiveButton() }
                  ) {
                      Text(text = stringResource(id = positiveButtonMessage))
                  }
              },
              dismissButton = {
                  Button(
                      onClick = {   negativeButtonMessage}
                  ) {
                      Text(text = stringResource(id = negativeButtonMessage))
                  }
              }
          )*/
    }
}

@Composable
@Preview(showBackground = true)
private fun DialogScreenPreview() {
    DialogScreen(
        true,
        titleResId = R.string.app_name,
        message = stringResource(id = R.string.app_name),
        positiveButtonMessage = R.string.app_name,
        negativeButtonMessage = R.string.app_name,
        onPositiveButton = {},
        onNegativeButton = {}
    )
}