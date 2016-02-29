package com.example.usuario.testapplication.process;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.usuario.testapplication.R;

public class MainActivity extends AppCompatActivity {
    Button access;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        access = (Button) findViewById(R.id.buttonAccess);
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                access(view);
            }
        });
    }
    public void access(View v) {
        // does something very interesting
        Intent intent = new Intent(this, InitialActivity.class);
        startActivity(intent);
    }
}
