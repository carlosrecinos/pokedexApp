package com.example.korinver.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        TextView usernameTextView = (TextView) findViewById(R.id.usernameText);
        TextView passwordTextView = (TextView) findViewById(R.id.passwordText);
        Bundle b = getIntent().getExtras();

        String username = null;
        String password = null;

        if(b != null){
            username = b.getString("USERNAME");
            password = b.getString("PASSWORD");
        }

        usernameTextView.setText(username);
        passwordTextView.setText(password);


    }
}
