package com.example.uicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText fullname, username, email, password, conpass;
    RadioGroup radioGroup;
    boolean isAllChecked = false;
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
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        fullname = findViewById(R.id.fname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        conpass = findViewById(R.id.cpass);
        radioGroup= findViewById(R.id.radio);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllChecked = CheckAll();
                if (isAllChecked) {
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(selectedId);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString(KEY_NAME,fullname.getText().toString());
                    editor.putString(KEY_USERNAME,username.getText().toString());
                    editor.putString(KEY_EMAIL,email.getText().toString());
                    editor.putString(KEY_PASS,password.getText().toString());
                    editor.putString(KEY_GENDER,radioButton.getText().toString());
                    editor.apply();
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this,"Signup Successfull",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private boolean CheckAll() {
        final String fname = fullname.getText().toString();
        final String uname = username.getText().toString();
        final String pass = password.getText().toString();
        final String pass2 = conpass.getText().toString();
        if (fullname.length() == 0) {
            fullname.setError("This Field is required");
            return false;
        }
        if (!fname.matches("[A-Za-z]+")) {
            fullname.setError("Name cannot contain symbols or digits");
            return false;
        }
        if (username.length() == 0) {
            username.setError("This Field is required");
            return false;
        }
        if (!uname.matches("^[a-zA-Z][a-zA-Z0-9_]{6,19}$")) {
            username.setError("Invalid Username");
            return false;
        }
        if(email.length()==0){
            email.setError("Email is required");
            return false;
        }
        if (password.length()==0)
        {
            password.setError("This Field is required");
            return false;
        }
        if(password.length()<8){
            password.setError("password must be minimum 8 characters");
            return false;
        }
        if(!pass.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$"))
        {
            password.setError("Invalid password");
            return false;
        }
        if(conpass.length()==0)
        {
            conpass.setError("This Field is required");
        }
        if(!pass.matches(pass2))
        {
            conpass.setError("Password is not matching");
            return false;
        }
        return true;
    }

}
