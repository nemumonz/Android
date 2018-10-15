package jp.gr.java_conf.testa.kotlinbox

import android.animation.ObjectAnimator
import android.app.Activity
import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*

val LOGTAG = "MainActivity"

class MainActivity : Activity() {
    var mOutputStrList = mutableListOf<String>()

    /** 生成処理 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リスナー登録
        setListener()

        setOutputChord(mOutputStrList.toString())

        // 保存データアクセサ初期化
        SaveDataAccessor.registerSharedPreferences(this)
    }

    fun setOutputChord(str: String) {
        imageView.setImageBitmap(createTextToBitmap(this, str, 16f, Typeface.MONOSPACE))
    }

    /** リスナー登録 */
    fun setListener() {
        input_reset.setOnClickListener {
            mOutputStrList.clear()
            setOutputChord(mOutputStrList.toString())
            lay_output.removeAllViews()
        }
        input_minor.setOnClickListener(EventBtn(this, "m"))
        input_sharp.setOnClickListener(EventBtn(this, resources.getString(R.string.str_sharp)))
        input_flat.setOnClickListener(EventBtn(this, resources.getString(R.string.str_flat)))

        input_c.setOnClickListener(EventBtn(this, resources.getString(R.string.str_c)))
        input_d.setOnClickListener(EventBtn(this, resources.getString(R.string.str_d)))
        input_e.setOnClickListener(EventBtn(this, resources.getString(R.string.str_e)))
        input_f.setOnClickListener(EventBtn(this, resources.getString(R.string.str_f)))
        input_g.setOnClickListener(EventBtn(this, resources.getString(R.string.str_g)))
        input_a.setOnClickListener(EventBtn(this, resources.getString(R.string.str_a)))
        input_b.setOnClickListener(EventBtn(this, resources.getString(R.string.str_b)))

        input_6.setOnClickListener(EventBtn(this, resources.getString(R.string.str_6)))
        input_7.setOnClickListener(EventBtn(this, resources.getString(R.string.str_7)))
        input_maj7.setOnClickListener(EventBtn(this, resources.getString(R.string.str_maj7)))
        input_harfdim.setOnClickListener(EventBtn(this, resources.getString(R.string.str_harfdim)))
        input_dim.setOnClickListener(EventBtn(this, resources.getString(R.string.str_dim)))
        input_dim_maj7.setOnClickListener(EventBtn(this, resources.getString(R.string.str_dim_maj7)))
        input_aug.setOnClickListener(EventBtn(this, resources.getString(R.string.str_aug)))
        input_aug_maj7.setOnClickListener(EventBtn(this, resources.getString(R.string.str_aug_maj7)))
        input_7sus4.setOnClickListener(EventBtn(this, resources.getString(R.string.str_7sus4)))

        input_flat5.setOnClickListener(EventBtn(this, resources.getString(R.string.str_flat5)))
        input_sharp5.setOnClickListener(EventBtn(this, resources.getString(R.string.str_sharp5)))
        input_flat9.setOnClickListener(EventBtn(this, resources.getString(R.string.str_flat9)))
        input_9.setOnClickListener(EventBtn(this, resources.getString(R.string.str_9)))
        input_sharp9.setOnClickListener(EventBtn(this, resources.getString(R.string.str_sharp9)))
        input_11.setOnClickListener(EventBtn(this, resources.getString(R.string.str_11)))
        input_sharp11.setOnClickListener(EventBtn(this, resources.getString(R.string.str_sharp11)))
        input_13.setOnClickListener(EventBtn(this, resources.getString(R.string.str_13)))
        input_flat13.setOnClickListener(EventBtn(this, resources.getString(R.string.str_flat13)))
    }
}

class EventBtn(val activity: MainActivity, val name: String) : View.OnClickListener {
    override fun onClick(v: View?) {
        if (v == null) {
            return
        }

        activity.lay_output.removeAllViews()

        // 選択状態更新
            v.isSelected = v.isSelected.not()
            if(v.isSelected) {
                activity.mOutputStrList.add(name)

                // 文字列連結
                var outStr = ""
                activity.mOutputStrList.forEach { outStr += it }
                // コード名表示
                activity.setOutputChord(outStr)

                val imgTriad = CodeImageDB.getTriad(name)
                val imgSharpFlat = CodeImageDB.getTriadSharpFlat(name)

            // 3和音画像生成
            val viewTriad = ViewCreator.addCodeImageView(activity, imgTriad)
            // #b画像生成
            ViewCreator.addSharpFlatImageView(activity, imgSharpFlat, viewTriad.id)

            // アニメーション
            startAnime(viewTriad, 400)
        } else {
            activity.mOutputStrList.remove(name)
//            activity.lay_output.childCount
//            activity.lay_output.removeViewAt(0)
        }
    }
}