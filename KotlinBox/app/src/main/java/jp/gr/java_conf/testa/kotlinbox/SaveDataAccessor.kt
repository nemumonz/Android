package jp.gr.java_conf.testa.kotlinbox

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by nemumonz on 2017/09/20.
 */
object SaveDataAccessor {
    var mSharedPreferences: SharedPreferences? = null

    val KEY_OUTPUT_CHORD = "OutputChord"

    fun registerSharedPreferences(context: Context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    /**
     * 出力コード書き出し
     */
    fun writeOutputChord(str: String) {
        val editor = mSharedPreferences?.edit()
        editor?.putString(KEY_OUTPUT_CHORD, str)
        editor?.commit()
    }

    /**
     * 出力コード読み込み
     */
    fun readOutputChord(): String {
        return mSharedPreferences?.getString(KEY_OUTPUT_CHORD, "") ?: ""
    }
}