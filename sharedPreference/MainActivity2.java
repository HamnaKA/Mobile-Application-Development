package com.example.uicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView full,user,email,pass,gender;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_USERNAME="username";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASS="pass";
    private static final String KEY_GENDER="gen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        full=findViewById(R.id.full);
        user=findViewById(R.id.user);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        gender=findViewById(R.id.gender);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String fname=sharedPreferences.getString(KEY_NAME,null);
        String usname=sharedPreferences.getString(KEY_USERNAME,null);
        String emaill=sharedPreferences.getString(KEY_EMAIL,null);
        String passw=sharedPreferences.getString(KEY_PASS,null);
        String genderr=sharedPreferences.getString(KEY_GENDER,null);

        if(fname!=null || usname!=null || email!=null || passw!=null || gender!=null){
            full.setText("Full Name- "+fname);
            user.setText("User Name-"+usname);
            email.setText("Email-"+emaill);
            pass.setText("Password-"+passw);
            gender.setText("Gender-"+genderr);
        }



    }
}
