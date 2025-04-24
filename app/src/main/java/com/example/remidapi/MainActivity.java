package com.example.remidapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterListClub.OnItemClickListener {

    RecyclerView rvListClub;
    AdapterListClub adapterListClub;
    ArrayList<ModalClub> dataClub = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rvListClub = findViewById(R.id.rvListClub);
        rvListClub.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ClubResponse> call = apiService.getAllTeam("English Premier League");

        call.enqueue(new Callback<ClubResponse>() {
            @Override
            public void onResponse(Call<ClubResponse> call, Response<ClubResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataClub = new ArrayList<>(response.body().getTeams());
                    adapterListClub = new AdapterListClub(dataClub, MainActivity.this);
                    rvListClub.setAdapter(adapterListClub);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClubResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(ModalClub clubModel) {
        Toast.makeText(this, clubModel.getNamaClub() + " - " + clubModel.getNamaStadium(), Toast.LENGTH_SHORT).show();

        Intent in = new Intent(MainActivity.this, DetailClub.class);
        in.putExtra("namaClub", clubModel.getNamaClub());     // key: "namaClub"
        in.putExtra("stadion", clubModel.getNamaStadium());       // key: "stadion"
        in.putExtra("imageUrl", clubModel.getImgUrl());     // key: "imageUrl"
        startActivity(in);
    }
}
