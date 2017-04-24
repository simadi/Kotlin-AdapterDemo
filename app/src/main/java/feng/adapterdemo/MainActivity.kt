package feng.adapterdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnlv1OnClick(v: View) {
        val lvNum= (v as Button).text.toString().substring(0,1).toInt()
        when(lvNum) {
            1 -> btnlv1.setOnClickListener { startActivity<ArrayAdapterActivity>() }
            2 -> btnlv2.setOnClickListener { startActivity<SimpleAdapterActivity>() }
            3 -> btnlv3.setOnClickListener { startActivity<SimpleCursorAdapterActivity>() }
            4 -> btnlv4.setOnClickListener { startActivity<BaseAdapterActivity>() }
            else -> toast("出错了！")
        }
    }
}
