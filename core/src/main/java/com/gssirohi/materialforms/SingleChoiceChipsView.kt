package com.gssirohi.materialforms

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.dateTimePicker
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.field_view_frame.view.*
import kotlinx.android.synthetic.main.input_date_time.view.*
import kotlinx.android.synthetic.main.input_single_choice.view.*
import java.text.SimpleDateFormat
import java.util.*

class SingleChoiceChipsView(item: FormItem, ctx: Context) : FieldView(item, ctx) {
    override fun provideFieldView(): View {
        var chipGroup:ChipGroup = View.inflate(context,R.layout.input_single_choice_chips,null) as ChipGroup

        var items = (item.field as Field.SingleChoiceChip).choices
        for(item in items){
            val chip = Chip(chipGroup.context)
            chip.text= item

            // necessary to get single selection working
            chip.isClickable = true
            chip.isCheckable = true
            chipGroup.addView(chip)
        }
        chipGroup.setOnCheckedChangeListener(object:ChipGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: ChipGroup?, p1: Int) {
                item.field.value = chipGroup.findViewById<Chip>(p1).text.toString()
            }
        })
        return chipGroup
    }

    init{
        Log.d("Single Choice View","init")
        initView()
        right_indication.visibility = View.VISIBLE
    }
}


