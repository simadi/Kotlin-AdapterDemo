package feng.adapterdemo

import android.content.CursorLoader
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.app.AppCompatActivity
import android.widget.CursorAdapter
import kotlinx.android.synthetic.main.activity_simple_cursor_adapter.*


class SimpleCursorAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_cursor_adapter)

        //AndroidManifest.xml 添加获取通讯录权限 <uses-permission Android:name="android.permission.READ_CONTACTS"></uses-permission>
        //模拟器需要添加联系人
        val cursor= CursorLoader(this, ContactsContract.Contacts.CONTENT_URI, null, null, null, null).loadInBackground()
        lv.adapter=SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, cursor,
                arrayOf(ContactsContract.Contacts.DISPLAY_NAME),intArrayOf(android.R.id.text1),
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)
    }
}
