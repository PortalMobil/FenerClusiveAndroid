package com.example.mylibrary.utils

import android.app.Activity
import android.content.Intent
import com.example.mylibrary.ui.LibraryActivity


class AppInterface {

    companion object {

        fun startApp(activity : Activity, token: String) {
            activity.startActivity(Intent(activity, LibraryActivity::class.java).putExtra("token", token))
        }
    }
}