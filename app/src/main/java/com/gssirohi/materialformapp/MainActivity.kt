package com.gssirohi.materialformapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gssirohi.materialforms.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var singleChoices = mutableListOf<String>("Economy","Special Economy","Business Class","Employee Class","Special Concession")
        var multiChoices = mutableListOf<String>("Swimming Pool","Car parking","Mini Bar","Free Wifi","Free Breakfast","Airport Pickup/Drop")

        var items = mutableListOf<FormItem>()
        items.add(FormItem(Field.Text("Gyanendra Singh Sirohi","Name",true,true),R.drawable.ic_action_user))
        items.add(FormItem(Field.Text("gyanendra.sirohi@gmail.com","Email",true,true),R.drawable.ic_email))
        items.add(FormItem(Field.SingleChoice("Economy",singleChoices,"Travel Class",true,true),R.drawable.ic_local_airport))
        items.add(FormItem(Field.MultiChoice(mutableListOf("Car parking"),multiChoices,"Hotel Amenities",true,true),R.drawable.ic_hotel))
        items.add(FormItem(Field.DateTime(Calendar.getInstance(),"Departure Date",true,true),R.drawable.ic_event))
        items.add(FormItem(Field.SingleChoiceChip("Male", mutableListOf("Male","Female"),"Gender",true,true),R.drawable.ic_face))
        items.add(FormItem(Field.Switch(false,"I am above 18",true),R.drawable.ic_face))
        var myForm = MaterialFormBuilder(this).title("Travel Package Form")
            .addItems(items)
            .onSubmitListner(object:MaterialForm.FormListner{
                override fun onFormSubmit(items: List<FormItem>) =
                    Toast.makeText(this@MainActivity,"Curr Value: ${items.get(0).field.currValue()}",Toast.LENGTH_SHORT).show()
            })
            .build()
        todo_form_container.addView(myForm)

    }
}
