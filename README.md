# MaterialFormLibrary

It is a library which provide an easy way to build material forms with minimal code.




![Showcase](https://github.com/gssirohi/MaterialFormLibrary/blob/master/art/MaterialFormShowcase.jpg)

# Dependency


```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

dependencies {
  ...
  implementation 'com.github.gssirohi:MaterialFormLibrary:Tag'
}
```


## Build Your Material Form

Build Form by providing Field Items and Submit Listener.

```

var fields = mutableListOf<FormItem>()

//add your field item(s) to 'fields'

var myForm = MaterialFormBuilder(this).title("Travel Package Form")
               .addItems(fields)
               .onSubmitListner(object:MaterialForm.FormListner{
                   override fun onFormSubmit(items: List<FormItem>) {
                   
                   }
                       
               })
               .build()
           formContainer.addView(myForm) 
```
        
## Text Field
```

var field = FormItem(Field.Text("Gyanendra Singh Sirohi","Name",isMandatory,isEditable),iconRes)

```

## Switch Field
```

var field = FormItem(Field.Switch(false,"I am above 18",isEditable),iconRes)

```

## Single Choice Field
```

var field = FormItem(Field.SingleChoice("Economy",singleChoices,"Travel Class",isMandatory,isEditable),iconRes)

```

## Single Choice Chips Field
```
var field = FormItem(Field.SingleChoiceChip("Male", mutableListOf("Male","Female"),"Gender",isMandatory,isEditable),iconRes)

```

## Multi Choice Field
```

var field = FormItem(Field.MultiChoice(preSelectedChoices,choices,"Hotel Amenities",isMandatory,isEditable),iconRes)

```

## Date & Time Field
```

var field = FormItem(Field.DateTime(Calendar.getInstance(),"Departure Date",isMandatory,isEditable),iconRes)

```
