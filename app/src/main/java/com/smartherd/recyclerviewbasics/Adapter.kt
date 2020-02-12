package com.smartherd.recyclerviewbasics

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class Adapter(data:ArrayList<Custom_class>,var context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    internal var data:List<Custom_class>

    init {
        this.data = data
    }


    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

         var title:TextView
         var image:ImageView
        var card:CardView

        init {

            title = itemView.findViewById(R.id.text_item)
            image = itemView.findViewById(R.id.image_item)
            card = itemView.findViewById(R.id.card_view)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false)
        return  ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)

        holder.card.setOnClickListener {

            val alert = Dialog(context)
            alert.setContentView(R.layout.alert)
            alert.window?.setType(WindowManager.LayoutParams.TYPE_TOAST)
            alert.setTitle("Custom_class")

            val name = alert.findViewById<TextView>(R.id.alert_name)
            val number = alert.findViewById<TextView>(R.id.alert_phone)
            val desc = alert.findViewById<TextView>(R.id.alert_desc)
            val image = alert.findViewById<ImageView>(R.id.alert_circle)
            val call = alert.findViewById<Button>(R.id.alert_call)


            name.text = data[position].title
            desc.text = data[position].desc
            number.text = data[position].phonenum
            image.setImageResource(data[position].image)

            alert.show()

            call.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", data[position].phonenum, null))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(context,intent, null)

                alert.dismiss()
            }
        }

    }
}