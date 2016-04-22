package com.example.domik.remem;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;



public class MainActivity extends Activity {

    private Client mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        EditText email,password;
        Button login,signIn;



        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.Password);
        login = (Button)findViewById(R.id.login_button);
        signIn = (Button)findViewById(R.id.sign_in_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            startActivity(new Intent(MainActivity.this, TimetableView.class));
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*make connection with server*/
                new connectTask().execute("");
                startActivity(new Intent(MainActivity.this,Register_one.class));
            }
        });
    }

    public class connectTask extends AsyncTask<String,String,Client> {

        @Override
        protected Client doInBackground(String... message) {
            mClient = new Client();
            mClient.run();

            return null;
        }
    }

}
