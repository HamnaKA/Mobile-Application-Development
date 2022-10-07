package com.example.onclick;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView first=(ImageView)this.findViewById(R.id.one);
        final ImageView second=(ImageView)this.findViewById(R.id.two);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                second.setVisibility(View.VISIBLE);
                view.setVisibility(View.GONE);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first.setVisibility(view.VISIBLE);
                view.setVisibility(View.GONE);
            }
        });

    }
}
