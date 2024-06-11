package com.learnvinesh.getflytasks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learnvinesh.getflytasks.R
import com.learnvinesh.getflytasks.models.PastEvents


class PastEventsRecyclerViewAdapter(private var eventsList:List<PastEvents>):RecyclerView.Adapter<PastEventsRecyclerViewAdapter.PastEventViewHolder>() {
    inner class PastEventViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val titleTV:TextView = itemView.findViewById(R.id.titleTextView)
        val descTV:TextView = itemView.findViewById(R.id.descriptionTextView)
        val dateTV:TextView = itemView.findViewById(R.id.circleView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastEventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.past_seminar_recycler_view_item,parent,false)
        return PastEventViewHolder(view)
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    override fun onBindViewHolder(holder: PastEventViewHolder, position: Int) {
        val currentPosi = eventsList[position]
        holder.apply {
            titleTV.text=currentPosi.title
            descTV.text=currentPosi.desc
            dateTV.text=currentPosi.date
        }
    }
}