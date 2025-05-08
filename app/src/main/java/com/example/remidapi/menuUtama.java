package com.example.remidapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menuUtama extends AppCompatActivity {

    Button btnEpl,btnLaLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_utama);

        Button btnEpl = findViewById(R.id.btnEpl);
        Button btnLaliga = findViewById(R.id.btnLaliga);

        btnEpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuUtama.this,MainActivity.class);
                startActivity(intent);
            }


        });

        btnLaliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuUtama.this,MainActivity2.class);
                startActivity(intent);
            }


        });

    }
}