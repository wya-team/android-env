package com.wya.env.util

import java.text.FieldPosition
import java.text.SimpleDateFormat
import java.util.*

/**
 * @date: 2017/6/17 13:59
 * @author: Chunjiang Mao
 * @classname: DynamicTimeFormatUtil
 * @describe: 动态时间格式化
 */

class DynamicTimeFormatUtil(yearFormat: String, dateFormat: String, timeFormat: String) : SimpleDateFormat(String.format(locale, "%s %s %s", yearFormat, dateFormat, timeFormat), locale) {

    private var mFormat = "%s"

    constructor(format: String) : this() {
        mFormat = format
    }

//    @JvmOverloads
    constructor(format: String = "%s", yearFormat: String = "yyyy年", dateFormat: String = "M月d日", timeFormat: String = "HH:mm") : this(yearFormat, dateFormat, timeFormat) {
        mFormat = format
    }

    override fun format(date: Date, toAppendTo: StringBuffer, pos: FieldPosition): StringBuffer {
        var toAppendTo = toAppendTo
        toAppendTo = super.format(date, toAppendTo, pos)

        val otherCalendar = calendar
        val todayCalendar = Calendar.getInstance()

        val hour = otherCalendar.get(Calendar.HOUR_OF_DAY)

        val times = toAppendTo.toString().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val moment = if (hour == 12) moments[0] else moments[hour / 6 + 1]
        val timeFormat = moment + " " + times[2]
        val dateFormat = times[1] + " " + timeFormat
        val yearFormat = times[0] + dateFormat
        toAppendTo.delete(0, toAppendTo.length)

        val yearTemp = todayCalendar.get(Calendar.YEAR) == otherCalendar.get(Calendar.YEAR)
        if (yearTemp) {
            val todayMonth = todayCalendar.get(Calendar.MONTH)
            val otherMonth = otherCalendar.get(Calendar.MONTH)
            //表示是同一个月
            if (todayMonth == otherMonth) {
                val temp = todayCalendar.get(Calendar.DATE) - otherCalendar.get(Calendar.DATE)
                when (temp) {
                    0 -> toAppendTo.append(timeFormat)
                    1 -> {
                        toAppendTo.append("昨天 ")
                        toAppendTo.append(timeFormat)
                    }
                    2 -> {
                        toAppendTo.append("前天 ")
                        toAppendTo.append(timeFormat)
                    }
                    3, 4, 5, 6 -> {
                        val dayOfMonth = otherCalendar.get(Calendar.WEEK_OF_MONTH)
                        val todayOfMonth = todayCalendar.get(Calendar.WEEK_OF_MONTH)
                        //表示是同一周
                        if (dayOfMonth == todayOfMonth) {
                            val dayOfWeek = otherCalendar.get(Calendar.DAY_OF_WEEK)
                            //判断当前是不是星期日     如想显示为：周日 12:09 可去掉此判断
                            if (dayOfWeek != 1) {
                                toAppendTo.append(weeks[otherCalendar.get(Calendar.DAY_OF_WEEK) - 1])
                                toAppendTo.append(' ')
                                toAppendTo.append(timeFormat)
                            } else {
                                toAppendTo.append(dateFormat)
                            }
                        } else {
                            toAppendTo.append(dateFormat)
                        }
                    }
                    else -> toAppendTo.append(dateFormat)
                }
            } else {
                toAppendTo.append(dateFormat)
            }
        } else {
            toAppendTo.append(yearFormat)
        }

        val length = toAppendTo.length
        toAppendTo.append(String.format(locale, mFormat, toAppendTo.toString()))
        toAppendTo.delete(0, length)
        return toAppendTo
    }

    companion object {

        private val locale = Locale.CHINA
        private val weeks = arrayOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
        private val moments = arrayOf("中午", "凌晨", "早上", "下午", "晚上")
    }

}
