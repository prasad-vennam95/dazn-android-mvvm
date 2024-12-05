package com.dazn.mvvm.app.host

import android.app.Activity
import androidx.core.app.ActivityCompat

class PermissionHandler {
    fun requestPermissions(activity: Activity, permissions: Array<String>, requestCode: Int) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }
}
