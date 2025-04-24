package com.example.remidapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/v1/json/3/search_all_teams.php")
    Call<ClubResponse> getAllTeam(@Query("l") String League);
}
