package com.example.linearlayout16sep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName, tvSport;
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
    }

    private void initialize() {
        tvName = findViewById(R.id.tvName);
        tvSport = findViewById(R.id.tvSport);
        btnReturn = findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(this);
        String name = getIntent().getStringExtra("name");
        tvName.setText(name);
        int sp = getIntent().getIntExtra("sport", -100);
        String Sport = "No Sport";
        if (sp == R.id.rbSoccer) Sport = "Soccer";
        if (sp == R.id.rbHandball) Sport = "Handball";
        if (sp == R.id.rbHockey) Sport = "Hockey";

        tvSport.setText(Sport);

    }


    @Override
    public void onClick(View view) {
        finish();
    }
}