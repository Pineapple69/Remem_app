package com.example.domik.remem;


import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Profile extends Activity{

    ImageView imageView3, imageView4, imageView5;
    TextView textView6, textView7, textView8;
    ImageButton imageButton;
    Button timetable, premium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView3 =(ImageView)findViewById(R.id.imageView3);
        imageView4 =(ImageView)findViewById(R.id.imageView4);
        imageView5 =(ImageView)findViewById(R.id.imageView5);
        textView6 =(TextView)findViewById(R.id.textView6);
        textView7 =(TextView)findViewById(R.id.textView7);
        textView8 =(TextView)findViewById(R.id.textView8);
        imageButton=(ImageButton)findViewById(R.id.imageButton);
        premium =(Button)findViewById(R.id.premium);
        timetable =(Button)findViewById(R.id.timetable);


        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, TimetableView.class));
            }
        });

        premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Premium1.class));
            }
        });
    }


}
