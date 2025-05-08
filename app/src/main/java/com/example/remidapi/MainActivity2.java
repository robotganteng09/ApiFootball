package com.example.remidapi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
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

public class MainActivity2 extends AppCompatActivity implements AdapterListClub.OnItemClickListener {

    RecyclerView rvListClub;
    ProgressBar PBLoading1;
    AdapterListClub adapterListClub1;
    ArrayList<ModalClub> dataClub1 = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        rvListClub = findViewById(R.id.rvListClub);
        PBLoading1 = findViewById(R.id.PBloading1); // pastikan ada di XML

        rvListClub.setLayoutManager(new LinearLayoutManager(this));
        rvListClub.setVisibility(View.GONE);
        PBLoading1.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ClubResponse> call = apiService.getAllTeam("Spanish La Liga");

        call.enqueue(new Callback<ClubResponse>() {
            @Override
            public void onResponse(Call<ClubResponse> call, Response<ClubResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataClub1 = new ArrayList<>(response.body().getTeams());
                    adapterListClub1 = new AdapterListClub(dataClub1, MainActivity2.this);
                    rvListClub.setAdapter(adapterListClub1);
                    rvListClub.setVisibility(View.VISIBLE);
                    PBLoading1.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity2.this, "Failed to load La Liga data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClubResponse> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(ModalClub clubModel) {
        Toast.makeText(this, clubModel.getNamaClub() + " - " + clubModel.getNamaStadium(), Toast.LENGTH_SHORT).show();
    }
}
