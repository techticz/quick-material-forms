package com.gssirohi.materialforms

import android.content.Context

class MaterialFormBuilder(val context:Context){
    private var title:String = ""
    private var items:MutableList<FormItem> = mutableListOf()
    private var listner: MaterialForm.FormListner? = null

    fun title(title:String):MaterialFormBuilder{
        this.title = title
        return this
    }

    fun addItems(items:List<FormItem>):MaterialFormBuilder{
        this.items.addAll(items)
        return this
    }

    fun onSubmitListner(listner:MaterialForm.FormListner):MaterialFormBuilder{
        this.listner = listner
        return this
    }

    fun build():MaterialForm{
        var form = MaterialForm(context,title,items,listner)
        return form
    }
}