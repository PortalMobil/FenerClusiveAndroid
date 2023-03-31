package com.portal.fenerclusivemodule.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.portal.fenerclusivemodule.R
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        supportActionBar?.hide()

        open_app.setOnClickListener {
            startActivity(Intent(this, LibraryActivity::class.java))
        }
    }
}