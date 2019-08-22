package com.gssirohi.materialforms

import android.content.Context
import android.util.Log
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.dateTimePicker
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import kotlinx.android.synthetic.main.field_view_frame.view.*
import kotlinx.android.synthetic.main.input_date_time.view.*
import kotlinx.android.synthetic.main.input_single_choice.view.*
import java.text.SimpleDateFormat
import java.util.*

class MultiChoiceView(item: FormItem, ctx: Context) : FieldView(item, ctx) {
    override fun provideFieldView(): View {
        var view = View.inflate(context,R.layout.input_single_choice,null)

        var items = (item.field as Field.MultiChoice).choices
        var initial = IntArray(2)
        initial.set(0,1)
        initial.set(1,3)
        view.setOnClickListener {
            var dialog = MaterialDialog(context).show{
                listItemsMultiChoice(allowEmptySelection = false,initialSelection = initial,items = items,waitForPositiveButton = false){d,init,choices->
                    var result = "";
                    var i = 0
                    for(choice in choices){
                        if(i++ == choices.size-1){
                            result = result+choice
                        } else {
                            result = result+choice+" | "
                        }

                    }
                    view.text_single_choice.text = result
                    item.field.setCurrValue(choices)
                }
            }
            dialog.setTitle(item.field.label)
        }
        return view
    }

    init{
        Log.d("Multi Choice View","init")
        initView()
        right_indication.visibility = View.VISIBLE


    }
}


