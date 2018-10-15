package jp.gr.java_conf.testa.kotlinbox

/**
 * Created by 895675 on 2017/10/03.
 */
object CodeImageDB {

    // 3和音画像取得
    fun getTriad(str : String): Int {
        return when(str) {
            "C" -> R.drawable.ic_code_c
            "D" -> R.drawable.ic_code_d
            "E" -> R.drawable.ic_code_e
            "F" -> R.drawable.ic_code_f
            "G" -> R.drawable.ic_code_g
            "A" -> R.drawable.ic_code_a
            "B" -> R.drawable.ic_code_b
            else -> 0
        }
    }

    fun getTriadSharpFlat(str : String): Int {
        return when(str) {
            "C" -> R.drawable.ic_flat
            "D" -> R.drawable.ic_flat
            "E" -> R.drawable.ic_flat
            "F" -> R.drawable.ic_flat
            "G" -> R.drawable.ic_flat
            "A" -> R.drawable.ic_flat
            "B" -> R.drawable.ic_flat
            else -> 0
        }
    }
}