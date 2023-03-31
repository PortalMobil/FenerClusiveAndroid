package com.portal.fenerclusivemodule.utils

import android.app.Activity
import android.content.Intent
import com.portal.fenerclusivemodule.ui.MainPageActivity


class AppInterface {

    companion object {

        fun startApp(activity : Activity, token: String) {
            activity.startActivity(Intent(activity, MainPageActivity::class.java).putExtra("token", token))
        }
    }
}