package com.example.domik.remem;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.provider.CalendarContract.Events;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.CalendarView;
import android.widget.ListView;
import android.app.Activity;

public class premium extends Activity {
    EditText editText, editText2, editText3;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium1);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        buttonNext = (Button) findViewById(R.id.buttonNext);


        buttonNext.setOnClickListener(new View.OnClickListener()

                                      {
                                          @Override
                                          public void onClick(View v) {
                                              String Name = editText.getText().toString();
                                              String Surname = editText2.getText().toString();
                                              String Status = editText3.getText().toString();
                                              if (Name.isEmpty() || Surname.isEmpty() || Status.isEmpty()) {
                                                  AlertDialog.Builder builder = new AlertDialog.Builder(premium.this);
                                                  builder.setMessage("Fill all blank!");
                                                  builder.setTitle("WARNING");
                                                  builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                      public void onClick(DialogInterface dialog, int id) {
                                                      }
                                                  });
                                                  AlertDialog dialog = builder.create();
                                                  dialog.show();
                                              } else
                                                  startActivity(new Intent(premium.this, premium1.class));
                                          }
                                      }

        );
    }

    public void eventClick(View view) {
        switch (view.getId()) {
            case R.id.radioButton1:
                editText.setBackgroundResource(R.color.Blue);
                editText2.setBackgroundResource(R.color.Blue);
                editText3.setBackgroundResource(R.color.Blue);
                break;
            case R.id.radioButton2:
                editText.setBackgroundResource(R.color.Red);
                editText2.setBackgroundResource(R.color.Red);
                editText3.setBackgroundResource(R.color.Red);
                break;
        }
    }
}