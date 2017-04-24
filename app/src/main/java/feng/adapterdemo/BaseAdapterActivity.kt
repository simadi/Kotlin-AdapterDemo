package feng.adapterdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_base_adapter.*
import java.util.*

class BaseAdapterActivity : AppCompatActivity() {

    private var data: List<Map<String, Any>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_adapter)

        val list = ArrayList<Map<String, Any>>()
        (1..10).mapTo(list) {
            hashMapOf<String, Any>("title" to "标题" + it.toString(),
                    "info" to "文本" + it.toString(),
                    "img" to R.drawable.i3)
        }
        //获取将要绑定的数据设置到data中
        data = list
        lv.adapter =  MyAdapter(this)
    }

    //ViewHolder静态类
    internal class ViewHolder {
        var img: ImageView? = null
        var title: TextView? = null
        var info: TextView? = null
    }

    inner class MyAdapter(context: Context) : BaseAdapter() {
        private var mInflater: LayoutInflater? = null

        init {this.mInflater = LayoutInflater.from(context)}

        override fun getCount(): Int {
            //How many items are in the data set represented by this Adapter.
            //在此适配器中所代表的数据集中的条目数
            return data!!.size
        }

        override fun getItem(position: Int): Any {
            // Get the data item associated with the specified position in the data set.
            //获取数据集中与指定索引对应的数据项
            return position
        }

        override fun getItemId(position: Int): Long {
            //Get the row id associated with the specified position in the list.
            //获取在列表中与指定索引对应的行id
            return position.toLong()
        }

        //获取一个在数据集中指定索引的视图来显示数据
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            var holder: ViewHolder? = null
            //如果缓存convertView为空，则需要创建View
            if (convertView == null) {
                //根据自定义的Item布局加载布局
                convertView = mInflater!!.inflate(R.layout.item_listview, null)

                holder = ViewHolder()
                holder.img = convertView!!.findViewById(R.id.img) as ImageView
                holder.title = convertView.findViewById(R.id.tv) as TextView
                holder.info = convertView.findViewById(R.id.info) as TextView
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.tag = holder
            } else {
                holder = convertView.tag as ViewHolder
            }

            holder.img!!.setBackgroundResource(data!![position]["img"] as Int)
            holder.title!!.text = data!![position]["title"] as String
            holder.info!!.text = data!![position]["info"] as String

            return convertView
        }

    }
}