package com.smartherd.recyclerviewbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item = ArrayList<Custom_class>()
        item.add(Custom_class("Android App","Android is goog","9897989728", R.drawable.background_two))
        item.add(Custom_class("Android App","Android is goog","9897989728", R.drawable.background_two))
        item.add(Custom_class("Android App","Android is goog","9897989728", R.drawable.background_two))
        item.add(Custom_class("Android App","Android is goog","9897989728", R.drawable.background_two))
        item.add(Custom_class("Android App","Android is goog","9897989728", R.drawable.background_two))
        item.add(Custom_class("Android App","Android is goog","9897989728", R.drawable.background_two))

        val adapter = Adapter(item, applicationContext)
        recycler_data.layoutManager = GridLayoutManager(applicationContext, 3)
        recycler_data.adapter = adapter
    }
}
