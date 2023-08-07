package com.example.mboga

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView

class ListAdapter(context: Context, dataArrayListAdapter: ArrayList<ListData?>?):
ArrayAdapter<ListData?>(context, R.layout.list_item,ArrayList()){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = counterView
        val listData = getItem(position)

        if (view == null){

            view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        }
        val listImage = view!!.findViewById<ImageView>(R.id.listImage)
        val listName = view.findViewById<ImageView>(R.id.listName)
        val listTime = view.findViewById<ImageView>(R.id.listTime)

        listImage.setImageResource(listData!!.image)
        listName.text = listData.name
        listTime.text = listData.time

        return view

    }

}