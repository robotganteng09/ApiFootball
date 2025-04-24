package com.example.remidapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class DetailClub extends AppCompatActivity {

    TextView tvClub;
    TextView tvStadium;
    ImageView imgStadium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_club);

        tvClub = findViewById(R.id.tvNamaClub);
        tvStadium = findViewById(R.id.tvDeskripsiClub);
        imgStadium = findViewById(R.id.imgClub);

        Intent intent = getIntent();
        String namaClub = intent.getStringExtra("namaClub");
        String namaStadium = intent.getStringExtra("stadion");
        String imgUrl = intent.getStringExtra("imageUrl");

        tvClub.setText(namaClub);
        tvStadium.setText(namaStadium);

        Glide.with(this)
                .load(imgUrl)
                .into(imgStadium);

    }
}