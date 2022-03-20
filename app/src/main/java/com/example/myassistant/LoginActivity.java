package com.example.myassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG_TAG = LoginActivity.class.getSimpleName();
    private EditText mPasswordView, mUserNameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserNameView = findViewById(R.id.username);
        mPasswordView = findViewById(R.id.password);
    }

    public void launchMainActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        String UserName = mUserNameView.getText().toString();
        String Pwd = mPasswordView.getText().toString();

        if(UserName.equalsIgnoreCase("a@b.com") && Pwd.equals("1234")){
            Intent MainIntent = new Intent(LoginActivity.this, CalendarActivity.class);
            startActivity(MainIntent);
            Toast.makeText(LoginActivity.this,"You are Sign in Successfuly.", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(LoginActivity.this,"Sorry,User Name or Password is incorrect.", Toast.LENGTH_LONG).show();
        }

    }
}