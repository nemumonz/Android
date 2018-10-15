package jp.gr.java_conf.testa.kotlinbox

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by 895675 on 2017/10/04.
 */
object ViewCreator {
    fun addCodeImageView(activity: MainActivity, imgId: Int): View {
        val imgView = ImageView(activity)
        imgView.id = 100
        imgView.setImageResource(imgId)
        val param = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        param.addRule(RelativeLayout.CENTER_IN_PARENT)
        activity.lay_output.addView(imgView, param)
        return imgView
    }

    fun addSharpFlatImageView(activity: MainActivity, imgId: Int, triadId: Int): View {
        val imgView = ImageView(activity)
        imgView.id = 101
        imgView.setImageResource(imgId)
        val param = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        param.addRule(RelativeLayout.ALIGN_LEFT, triadId)
        activity.lay_output.addView(imgView, param)
        return imgView
    }
}