package com.example.login;

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

        username =findViewById(R.id.username);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.loginbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),pass.getText().toString());
            }
        });
    }
    private void validate(String username,String pass){
        if((username.equals("admin")) && (pass.equals("123"))){
            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_LONG).show();
        }
    }


}
