package com.portal.fenerclusive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.portal.fenerclusivemodule.utils.AppInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_call.setOnClickListener {
            AppInterface.startApp(this, "Test")
        }
    }
}