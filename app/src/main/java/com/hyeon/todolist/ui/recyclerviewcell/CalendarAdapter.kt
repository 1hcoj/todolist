package com.hyeon.todolist.ui.recyclerviewcell

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hyeon.todolist.R
import com.hyeon.todolist.databinding.CalendarCellBinding

class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {
    private var dayList : ArrayList<String>

    constructor(dayList :ArrayList<String>){
        this.dayList = dayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CalendarCellBinding.inflate(inflater,parent,false)
        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(dayList[position],R.drawable.noncheck_ic)
    }

    override fun getItemCount(): Int {
        return dayList.size
    }

    class CalendarViewHolder : RecyclerView.ViewHolder{
        private val binding : CalendarCellBinding

        fun bind(dayOfWeek: String, imageRsc: Int) {
            with(binding) {
                textViewDay.text = dayOfWeek
                imageViewCheck.setImageResource(imageRsc)
                layoutView.setOnClickListener {
                    textViewDay.setTextColor(Color.BLUE)
                }
            }
        }

        constructor(binding : CalendarCellBinding) : super(binding.root){
            this.binding = binding
        }

    }
}