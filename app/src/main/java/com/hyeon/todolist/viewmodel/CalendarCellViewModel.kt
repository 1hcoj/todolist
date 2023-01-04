package com.hyeon.todolist.viewmodel

import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class CalendarCellViewModel : ViewModel() {
    var selectedDate : LocalDate = LocalDate.now()

    /** 한달 간 날짜를 string ArrayList 에 저장하여 반환 */
    fun daysInMonthArray() : ArrayList<String>{
        val dayList : ArrayList<String> = arrayListOf()

        var yearMonth : YearMonth = YearMonth.from(selectedDate)
        val lastDay = yearMonth.lengthOfMonth()
        val firstDay = selectedDate.withDayOfMonth(1)
        val dayOfWeek = firstDay.dayOfWeek.value - 1

        for (i in 1 until 42){
            if (i <= dayOfWeek || i > lastDay + dayOfWeek){
                dayList.add("")
            }
            else {
                dayList.add((i-dayOfWeek).toString())
            }
        }
        return dayList
    }
    /** 연, 월 정보를 Format 으로 전달 */
    fun monthYearFromDate(): String {
        val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월")
        return selectedDate.format(formatter)
    }

    fun moveNext(){
        selectedDate = selectedDate.plusMonths(1)
    }
    fun movePrev(){
        selectedDate = selectedDate.minusMonths(1)
    }

}