<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    xmlns:tools="http://schemas.android.com/tools"
    android:background="@color/black"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <EditText
        android:id="@+id/username"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="70dp"
        android:layout_marginTop="124dp"
        android:hint="Username"
        android:ems="10"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/password"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="70dp"
        android:layout_marginTop="40dp"
        android:ems="10"
        android:hint="Password"
        android:inputType="textPassword"/>

    <Button
        android:id="@+id/loginbtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="44dp"
        android:text="Login"/>


</LinearLayout>

package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.loginbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), pass.getText().toString());

            }
        });
    }
    private void validate(String username,String pass){
        if((username.equals("hamna")) && (pass.equals("123"))){
            Toast.makeText(getApplicationContext(), "Login Sucess", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_SHORT).show();
        }



    }
}
