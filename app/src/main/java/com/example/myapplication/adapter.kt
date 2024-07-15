package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.model.AdapterClass
import androidx.recyclerview.widget.RecyclerView

class adapter(val messagelist: ArrayList<message>):RecyclerView.Adapter<adapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view : View
       if(viewType ==0){
           view =  LayoutInflater.from(parent.context).inflate(R.layout.right_chat,parent,false)
       }
        else{
            view = LayoutInflater.from(parent.context).inflate(R.layout.left_chat,parent,false)
       }

        return ViewHolder(view)

    }
    override fun getItemViewType(position: Int): Int {
        val message = messagelist[position]
        return if(message.isuser) 0 else 1
    }

    override fun getItemCount(): Int {
        return messagelist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mesg = messagelist[position]
            holder.chat.text = mesg.meassage

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chat : TextView = itemView.findViewById(R.id.chat)
    }

}