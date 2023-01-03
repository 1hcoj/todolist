package com.hyeon.todolist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeon.todolist.R
import com.hyeon.todolist.databinding.FragmentHomeBinding
import com.prolificinteractive.materialcalendarview.CalendarMode


class HomeFragment : Fragment(){
    lateinit var binding : FragmentHomeBinding
    private var isMonthMode : Boolean = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonChangeMW.apply {
            setButton()
            setOnClickListener {
                isMonthMode = !isMonthMode
                setButton()
                calendarModeChange()
            }
        }
        calendarModeChange()
    }
    private fun setButton() {
        binding.buttonChangeMW.apply {
            if (isMonthMode) {
                text = "월"
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_up_24, 0)
            } else {
                text = "주"
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_arrow_drop_down_24, 0)
            }
        }
    }

    private fun calendarModeChange() {
        val calendarMode =  if(isMonthMode){ CalendarMode.MONTHS } else{ CalendarMode.WEEKS }
        binding.calendarView.state().edit().setCalendarDisplayMode(calendarMode).commit()
    }


}