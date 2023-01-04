package com.hyeon.todolist.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hyeon.todolist.R
import com.hyeon.todolist.databinding.FragmentHomeBinding
import com.hyeon.todolist.ui.recyclerviewcell.CalendarAdapter
import com.hyeon.todolist.viewmodel.CalendarCellViewModel
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


class HomeFragment : Fragment(){
    private lateinit var binding : FragmentHomeBinding
    private var isMonthMode : Boolean = true
    /** 날짜 정보를 가진 ViewModel */
    private val calendarCellViewModel by lazy{
        ViewModelProvider(this)[CalendarCellViewModel::class.java]
    }

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
        setMonthView()

        with(binding){
            /** 단위 ( 월, 주 ) 선택하는 버튼 초기화 및 이벤트 리스너 등록 */
            buttonChangeMW.apply {
                setButton()
                setOnClickListener {
                    isMonthMode = !isMonthMode
                    setButton()
                }
            }
            /** 이전 월 */
            buttonPre.setOnClickListener {
                calendarCellViewModel.movePrev()
                setMonthView()
            }
            /** 다음 월 */
            buttonNext.setOnClickListener {
                calendarCellViewModel.moveNext()
                setMonthView()
            }
        }
    }

    /** 한달 간격의 일정을 화면에 표시 */
    private fun setMonthView() {
        binding.textViewYearMonth.text = calendarCellViewModel.monthYearFromDate()

        val adapter : CalendarAdapter = CalendarAdapter(calendarCellViewModel.daysInMonthArray())
        val manager : RecyclerView.LayoutManager = GridLayoutManager(activity,7)

        binding.recyclerview.apply {
            layoutManager = manager
            setAdapter(adapter)
        }
    }

    /** 월, 주 캘린더 정보 변경 버튼 클릭시 버튼 변화 */
    private fun setButton() {
        val term : String
        val buttonImageRsc : Int

        if (isMonthMode){
            term = "월"
            buttonImageRsc = R.drawable.ic_baseline_arrow_drop_up_24
        }else {
            term = "주"
            buttonImageRsc = R.drawable.ic_baseline_arrow_drop_down_24
        }

        binding.buttonChangeMW.apply {
            text = term
            setCompoundDrawablesWithIntrinsicBounds(0, 0, buttonImageRsc, 0)
        }
    }
}