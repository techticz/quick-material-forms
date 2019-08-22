package com.gssirohi.materialforms

import android.content.Context
import android.util.Log
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.dateTimePicker
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import kotlinx.android.synthetic.main.field_view_frame.view.*
import kotlinx.android.synthetic.main.input_date_time.view.*
import java.text.SimpleDateFormat
import java.util.*

class DateTimeView(item: FormItem, ctx: Context) : FieldView(item, ctx) {
    override fun provideFieldView(): View {
        var view = View.inflate(context,R.layout.input_date_time,null)

        view.setOnClickListener {
            var dialog = MaterialDialog(context).show {
                dateTimePicker(requireFutureDateTime = true) { _, dateTime ->
                    view.text_date.text = dateTime.displayDate()
                    view.text_time.text = dateTime.displayTime()
                    item.field.setCurrValue(dateTime)
                }
            }
            dialog.setTitle(item.field.label)
        }
        return view
    }

    init{
        Log.d("Date Time View","init")
        initView()
        right_indication.visibility = View.VISIBLE
    }
}

private fun Calendar.displayDate(): CharSequence? {
    val date = this.time
    val sdf = SimpleDateFormat("dd MMM yyyy")
    return sdf.format(date)
}

private fun Calendar.displayTime(): CharSequence? {
    val date = this.time
    val sdf = SimpleDateFormat("hh:mm aaa")
    return sdf.format(date)
}

private fun Calendar.displayDateTime(): CharSequence? {
    val date = this.time
    val sdf = SimpleDateFormat("dd MMM yyyy hh:mm aaa")
    return sdf.format(date)
}

