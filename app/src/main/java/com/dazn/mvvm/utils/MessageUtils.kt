package com.dazn.mvvm.utils

import android.Manifest
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar

object MessageUtils {

    fun Context.showToastMessage(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    fun View.showSnackbarMessage(message: String, duration: Int = Snackbar.LENGTH_SHORT, actionText: String? = null, action: (() -> Unit)? = null) {
        val snackbar = Snackbar.make(this, message, duration)
        if (actionText != null && action != null) {
            snackbar.setAction(actionText) { action() }
        }
        snackbar.show()
    }

    fun Context.showDialog(title: String, message: String, positiveButtonText: String = "OK", positiveAction: (() -> Unit)? = null, negativeButtonText: String? = null, negativeAction: (() -> Unit)? = null) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonText) { _, _ -> positiveAction?.invoke() }

        if (negativeButtonText != null) {
            builder.setNegativeButton(negativeButtonText) { _, _ -> negativeAction?.invoke() }
        }

        builder.show()
    }

    fun Context.showNotification(
        channelId: String,
        channelName: String,
        notificationId: Int,
        title: String,
        message: String,
        askPermissions: (Boolean) -> Unit
    ) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create Notification Channel for Android O and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            askPermissions(false)
        } else {
            NotificationManagerCompat.from(this).notify(notificationId, notification)
        }
    }
}
