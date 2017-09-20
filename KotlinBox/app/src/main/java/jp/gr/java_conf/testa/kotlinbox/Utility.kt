package jp.gr.java_conf.testa.kotlinbox

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by nemumonz on 2017/09/20.
 */

/**
 * 文字列からBitmapを生成
 */
fun createTextToBitmap(context: Context, str: String, typeface: Typeface): Bitmap? {
    if(str == "") {
        return null
    }

    val textView = TextView(context)
    textView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    textView.text = str
    textView.typeface = typeface

    // TextViewにサイズを設定
    textView.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
    textView.layout(0, 0, textView.measuredWidth, textView.measuredHeight)

    // Bitmapに変換
    val bitmap = Bitmap.createBitmap(
            textView.measuredWidth, textView.measuredHeight, Bitmap.Config.ARGB_8888 )
    textView.draw(Canvas(bitmap))

    Log.d(LOGTAG, "textView.measuredWidth:" + textView.measuredWidth + ", textView.measuredHeight:" + textView.measuredHeight)

    return bitmap
}

/**
 * ディスプレイの幅を取得
 */
fun getDisplayWidth(activity: Activity): Int {
    return activity.resources.displayMetrics.widthPixels
}

/**
 * ディスプレイの高さを取得
 */
fun getDisplayHeight(activity: Activity): Int {
    return activity.resources.displayMetrics.heightPixels
}

/**
 * アニメーション開始
 */
fun startAnime(obj: Any?, duration: Long) {
    // Y軸回転
    val rotationAnim = ObjectAnimator.ofFloat(obj, "rotationY", 0f, 360f)
    rotationAnim.duration = duration
    rotationAnim.interpolator = AccelerateDecelerateInterpolator()
    rotationAnim.start()

    val animatorList: MutableList<Animator> = mutableListOf<Animator>()

    // 透過度変化　透過していく
    val alphaAnime = ObjectAnimator.ofFloat(obj, "alpha", 1f, 0.3f)
    alphaAnime.duration = (duration / 2)
    alphaAnime.interpolator = AccelerateDecelerateInterpolator()
    animatorList.add(alphaAnime)

    // 透過度変化　元に戻る
    val alphaAnime2 = ObjectAnimator.ofFloat(obj, "alpha", 0.3f, 1f)
    alphaAnime2.duration = (duration / 2)
    alphaAnime2.interpolator = AccelerateDecelerateInterpolator()
    animatorList.add(alphaAnime2)

    val animatorSet = AnimatorSet()
    animatorSet.playSequentially(animatorList)
    animatorSet.start()
}