package com.bignerdranch.android.fetchrewardscodingproblem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val items: List<Items>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    // Displays a single row's layout
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemId: TextView = view.findViewById(R.id.itemId)
        val listId: TextView = view.findViewById(R.id.listId)
        val name: TextView = view.findViewById(R.id.name)
    }
    //when recyclerview needs a new ViewHolder(new row in list)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }
    //Binds the data to the ViewHolder
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.itemId.text = "ID: ${item.id}"
        holder.listId.text = "ListID: ${item.listId}"
        holder.name.text = "Name: ${item.name}"
    }
    //returns total number of items in list
    override fun getItemCount(): Int = items.size
}