package com.gssirohi.materialforms

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.field_view_frame.view.*

abstract class FieldView(val item:FormItem, ctx: Context): LinearLayout(ctx) {
    init {
        Log.d("FieldView","init");
    }

    fun initView(){
        var view = View.inflate(context,R.layout.field_view_frame,null)
        if(item.field.isMandatory)
        view.field_label.text = item.field.label
        item.iconRes?.let{
            view.image_field.visibility = View.VISIBLE
            view.image_field.setImageResource(item.iconRes)
        }

        var fieldView = provideFieldView()
        view.findViewById<FrameLayout>(R.id.frame_field).addView(fieldView)
        addView(view)
    }

    abstract fun provideFieldView(): View
}