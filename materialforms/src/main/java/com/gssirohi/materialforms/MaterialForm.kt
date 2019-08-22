package com.gssirohi.materialforms

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.material_form_layout.view.*


class MaterialForm(
    ctx: Context,
    val title: String,
    val items: MutableList<FormItem>,
    val listner: FormListner?

) : LinearLayout(ctx) {

    init {
        initUi()
    }

    private fun initUi() {
        val form =  View.inflate(context,R.layout.material_form_layout,null);
        form.form_title.text = title
        form.button_submit.setOnClickListener { listner?.onFormSubmit(items) }
        for (item in items){
            when{
                item.field is Field.Text->{
                    form.item_container.addView(TextInputView(item,context))
                }
                item.field is Field.Switch->{
                    form.item_container.addView(SwitchView(item,context))
                }
                item.field is Field.DateTime->{
                    form.item_container.addView(DateTimeView(item,context))
                }
                item.field is Field.SingleChoice->{
                    form.item_container.addView(SingleChoiceView(item,context))
                }
                item.field is Field.SingleChoiceChip->{
                    form.item_container.addView(SingleChoiceChipsView(item,context))
                }
                item.field is Field.MultiChoice->{
                    form.item_container.addView(MultiChoiceView(item,context))
                }
            }
        }
        form.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        addView(form)
    }

    interface FormListner{
        fun onFormSubmit(items:List<FormItem>)
    }
}