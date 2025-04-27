package com.example.remidapi;

import com.google.gson.annotations.SerializedName;

public class ModalClub {

    @SerializedName("strTeam")
    private String namaClub;

    @SerializedName("strStadium")
    private String namaStadium;

    @SerializedName("strBadge")
    private String imgUrl;

    public ModalClub(String namaClub, String namaStadium, String imgUrl){
        this.namaClub = namaClub;
        this.namaStadium = namaStadium;
        this.imgUrl = imgUrl;
    }

    public String getNamaClub(){
        return namaClub;
    }

    public String getNamaStadium(){
        return namaStadium;
    }

    public String getImgUrl(){
        return imgUrl;
    }
}
