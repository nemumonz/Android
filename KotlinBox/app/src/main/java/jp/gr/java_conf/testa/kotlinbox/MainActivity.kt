package jp.gr.java_conf.testa.kotlinbox

import android.animation.ObjectAnimator
import android.app.Activity
import android.graphics.*
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

val LOGTAG = "MainActivity"

class MainActivity : Activity() {
    /** 生成処理 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リスナー登録
        setListener()

        // 保存データ読み込み
        SaveDataAccessor.registerSharedPreferences(this)
        val outputChord = SaveDataAccessor.readOutputChord()
        Log.d(LOGTAG, "outputChord:" + outputChord)

        setOutputChord(outputChord)
    }

    fun setOutputChord(str: String) {
        imageView.setImageBitmap(createTextToBitmap(this, str, Typeface.MONOSPACE))
    }

    /** リスナー登録 */
    fun setListener() {
        input_reset.setOnClickListener {
            Log.d(LOGTAG, resources.getString(R.string.str_reset))
            val str = ""
            SaveDataAccessor.writeOutputChord(str)
            setOutputChord(str)
        }
        input_minor.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_minor)) }
        input_sharp.setOnClickListener {
            Log.d(LOGTAG, resources.getString(R.string.str_sharp))
            val str = SaveDataAccessor.readOutputChord() + resources.getString(R.string.str_sharp)
            SaveDataAccessor.writeOutputChord(str)
            setOutputChord(str)
            startAnime(imageView, 400)
        }
        input_flat.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_flat)) }

        input_c.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_c)) }
        input_d.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_d)) }
        input_e.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_e)) }
        input_f.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_f)) }
        input_g.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_g)) }
        input_a.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_a)) }
        input_b.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_b)) }

        input_6.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_6)) }
        input_7.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_7)) }
        input_maj7.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_maj7)) }
        input_harfdim.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_harfdim)) }
        input_dim.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_dim)) }
        input_dim_maj7.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_dim_maj7)) }
        input_aug.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_aug)) }
        input_aug_maj7.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_aug_maj7)) }
        input_7sus4.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_7sus4)) }

        input_flat5.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_flat5)) }
        input_sharp5.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_sharp5)) }
        input_flat9.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_flat9)) }
        input_9.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_9)) }
        input_sharp9.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_sharp9)) }
        input_11.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_11)) }
        input_sharp11.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_sharp11)) }
        input_13.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_13)) }
        input_flat13.setOnClickListener { Log.d(LOGTAG, resources.getString(R.string.str_flat13)) }
    }
}
