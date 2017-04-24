package feng.adapterdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_array_adapter.*

class ArrayAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_adapter)

        lv.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrayListOf("测试数据1","测试数据2","测试数据3","测试数据4"))
    }
}
