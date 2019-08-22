package com.gssirohi.materialforms

import android.content.Context
import android.util.Log
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.dateTimePicker
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import kotlinx.android.synthetic.main.field_view_frame.view.*
import kotlinx.android.synthetic.main.input_date_time.view.*
import kotlinx.android.synthetic.main.input_single_choice.view.*
import java.text.SimpleDateFormat
import java.util.*

class SingleChoiceView(item: FormItem, ctx: Context) : FieldView(item, ctx) {
    override fun provideFieldView(): View {
        var view = View.inflate(context,R.layout.input_single_choice,null)

        var items = (item.field as Field.SingleChoice).choices
        view.setOnClickListener {
            var dialog = MaterialDialog(context)
            .show{
                listItemsSingleChoice(items = items) { dialog, index, text ->
                    view.text_single_choice.text = text
                    item.field.setCurrValue(text)
                }
            }
            dialog.setTitle(item.field.label)
        }
        return view
    }

    init{
        Log.d("Single Choice View","init")
        initView()
        right_indication.visibility = View.VISIBLE
    }
}


