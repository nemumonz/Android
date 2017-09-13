package jp.gr.java_conf.testa.kotlinbox

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_title.setText(title)
    }
}
