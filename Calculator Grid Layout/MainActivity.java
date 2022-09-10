package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    String oldno,newno;
    String op="+";
    boolean isnewop=true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.result);
    }

    public void NumberEvent(View view) {
         if(isnewop){
             ed1.setText(" ");
         }
         isnewop=false;
         String number=ed1.getText().toString();
         switch (view.getId())
        {
            case R.id.bu0:
                number=number+"0";
                break;
            case R.id.bu1:
                number=number+"1";
                break;
            case R.id.bu2:
                number=number+"2";
                break;
            case R.id.bu3:
                number=number+"3";
                break;
            case R.id.bu4:
                number=number+"4";
                break;
            case R.id.bu5:
                number=number+"5";
                break;
            case R.id.bu6:
                number=number+"6";
                break;
            case R.id.bu7:
                number=number+"7";
                break;
            case R.id.bu8:
                number=number+"8";
                break;
            case R.id.bu9:
                number=number+"9";
                break;
        }
        ed1.setText(number);
    }
    public void OperatorEvent(View view){
           isnewop=true;
           oldno=ed1.getText().toString();
           switch (view.getId()) {
               case R.id.buplus:
                   op = "+";
                   break;
               case R.id.buminus:
                   op = "-";
                   break;
               case R.id.bumul:
                   op = "*";
                   break;
               case R.id.budivide:
                   op = "/";
                   break;
           }

    }
    public void EqualEvent(View view){
        newno=ed1.getText().toString();
        double result=0.0;
        switch (op)
        {
            case "+":
                  result=Double.parseDouble(oldno)+Double.parseDouble(newno);
                  break;
            case "-":
                  result=Double.parseDouble(oldno)-Double.parseDouble(newno);
                  break;
            case "*":
                  result=Double.parseDouble(oldno)*Double.parseDouble(newno);
                  break;
            case "/":
                  result=Double.parseDouble(oldno)/Double.parseDouble(newno);
                  break;

        }
        ed1.setText(result+"");
    }

}
