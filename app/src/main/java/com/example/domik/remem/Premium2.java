package com.example.domik.remem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Domik on 12.4.2016.
 */
public class Premium2 extends Activity{

    TextView textView2,textView3, textView4, textView5;
    EditText editText,editText2,editText3;
    Button buttonSave;
    DatePicker datePicker;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium2);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        buttonSave = (Button) findViewById(R.id.buttonSave);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Premium2.this, Profile.class));
            }
        });
    }



}
