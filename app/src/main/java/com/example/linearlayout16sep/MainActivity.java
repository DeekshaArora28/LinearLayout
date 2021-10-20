package com.example.linearlayout16sep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edName;
    RadioGroup rgSport;
    Button btnNext, btnClear, btnQuit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        edName  = findViewById(R.id.edName);
        rgSport = findViewById(R.id.rgSport);
        btnClear =  findViewById(R.id.btnClear);
        btnNext =  findViewById(R.id.btnNext);
        btnQuit=  findViewById(R.id.btnQuit);

        btnClear.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnQuit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.btnClear:
                clearWidgets();
                break;
            case R.id.btnNext:
                goToSecondActivtiy();
                break;
            case R.id.btnQuit:
                System.exit(0);
                break;
        }

    }

    private void goToSecondActivtiy() {
        String name = edName.getText().toString();
        int rbid = rgSport.getCheckedRadioButtonId();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("Sport", rbid);

        startActivity(intent);
    }

    private void clearWidgets() {
        edName.setText(null);
        rgSport.clearCheck();
    }
}