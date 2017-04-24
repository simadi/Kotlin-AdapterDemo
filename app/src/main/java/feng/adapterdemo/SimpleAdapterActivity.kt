package feng.adapterdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter

import kotlinx.android.synthetic.main.activity_simple_adapter.*
class SimpleAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter)

       var list = ArrayList<Map<String, Any>>()
        (1..10).mapTo(list) {
            hashMapOf<String, Any>("title" to "标题" + it.toString(),
                                    "info" to "文本" + it.toString(),
                                    "img" to R.drawable.i1)
        }
        lv.adapter = SimpleAdapter(this, list,R.layout.item_listview,
                arrayOf<String>("title","info","img"),
                intArrayOf(R.id.tv,R.id.info,R.id.img))
    }
}
