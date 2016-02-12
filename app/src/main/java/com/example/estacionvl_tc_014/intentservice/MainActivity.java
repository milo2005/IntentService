package com.example.estacionvl_tc_014.intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.estacionvl_tc_014.intentservice.services.ContadorService;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button a1,a3,a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (Button) findViewById(R.id.btn_a1);
        a2 = (Button) findViewById(R.id.btn_a2);
        a3 = (Button) findViewById(R.id.btn_a3);

        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ContadorService.class);
        switch (v.getId()){
            case R.id.btn_a1:
                intent.setAction(ContadorService.ACTION_1);
                break;
            case R.id.btn_a2:
                intent.setAction(ContadorService.ACTION_2);
                break;
            case R.id.btn_a3:
                intent.setAction(ContadorService.ACTION_3);
                break;
        }
        startService(intent);

    }
}
