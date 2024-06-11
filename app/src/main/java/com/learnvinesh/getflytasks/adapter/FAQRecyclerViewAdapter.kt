package com.learnvinesh.getflytasks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.learnvinesh.getflytasks.databinding.FaqRecyclerViewQuestionItemBinding
import com.learnvinesh.getflytasks.models.FAQQuestions

class FAQRecyclerViewAdapter(private var faqs:List<FAQQuestions>):RecyclerView.Adapter<FAQRecyclerViewAdapter.FAQViewHolder>() {

    inner class FAQViewHolder(private var binding:FaqRecyclerViewQuestionItemBinding):RecyclerView.ViewHolder(binding.root) {
            val qtv = binding.questionTextView
            val anstv = binding.answerTextView
            val img = binding.expandableImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQViewHolder {
        val binding = FaqRecyclerViewQuestionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FAQViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return faqs.size
    }

    override fun onBindViewHolder(holder: FAQViewHolder, position: Int) {
        val quesList = faqs[position]
        holder.apply {
            qtv.text = quesList.question
            anstv.text = quesList.answer

            val isExapndable:Boolean = quesList.isExpandable
            anstv.visibility = if (isExapndable) View.VISIBLE else View.GONE

            img.setOnClickListener {
                isAnyItemExpanded(position)
                quesList.isExpandable = !quesList.isExpandable
                notifyItemChanged(position,Unit)
            }
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = faqs.indexOfFirst {
            it.isExpandable
        }
        if (temp >= 0 && temp != position){
            faqs[temp].isExpandable = false
            notifyItemChanged(temp , 0)
        }
    }
}