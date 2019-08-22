package com.gssirohi.materialforms

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import kotlinx.android.synthetic.main.field_view_frame.view.*

class SwitchView(item: FormItem, ctx: Context) : FieldView(item, ctx) {
    override fun provideFieldView(): View {
        var view = View.inflate(context,R.layout.input_switch,null)
        (view as Switch).text = item.field.label
        (view as Switch).setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                item.field.setCurrValue(isChecked)
            }
        })
        return view
    }

    init{
        Log.d("SwitchView","init")
        initView()
        field_label.visibility = View.GONE
    }
}