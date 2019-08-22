package com.gssirohi.materialforms

import java.util.*

sealed class Field(val type:FieldType, val label:String, var isMandatory:Boolean, var isEditable:Boolean) {
    abstract fun  currValue():Any
    abstract fun setCurrValue(obj:Any)
    class Text(var value:String,label:String,isMandatory: Boolean,isEditable:Boolean):Field(FieldType.TEXT,label,isMandatory,isEditable) {
        override fun setCurrValue(obj: Any) {
            value = obj as String
        }

        override fun currValue(): String {
            return value
        }
    }

    class Switch(var value:Boolean, label:String, isEditable:Boolean):Field(FieldType.SWITCH,label,false,isEditable) {
        override fun setCurrValue(obj: Any) {
            value = obj as Boolean
        }

        override fun currValue(): Boolean {
            return value
        }
    }
    class DateTime(var value: Calendar, label:String,isMandatory: Boolean, isEditable:Boolean):Field(FieldType.DATE_TIME,label,isMandatory,isEditable) {
        override fun setCurrValue(obj: Any) {
            value = obj as Calendar
        }

        override fun currValue(): Calendar {
            return value
        }
    }
    class SingleChoice(var value: String,var choices:List<String>, label:String,isMandatory: Boolean, isEditable:Boolean):Field(FieldType.SINGLE_CHOICE,label,isMandatory,isEditable) {
        override fun setCurrValue(obj: Any) {
            value = obj as String
        }

        override fun currValue(): String {
            return value
        }
    }
    class SingleChoiceChip(var value: String,var choices:List<String>, label:String,isMandatory: Boolean, isEditable:Boolean):Field(FieldType.SINGLE_CHOICE,label,isMandatory,isEditable) {
        override fun setCurrValue(obj: Any) {
            value = obj as String
        }

        override fun currValue(): String {
            return value
        }
    }
    class MultiChoice(var values: List<String>,var choices:List<String>, label:String,isMandatory: Boolean, isEditable:Boolean):Field(FieldType.MULTI_CHOICE,label,isMandatory,isEditable) {
        override fun setCurrValue(obj: Any) {
            values = obj as List<String>
        }

        override fun currValue(): List<String> {
            return values
        }
    }
}