package com.example.remidapi;

import java.util.List;

public class ClubResponse {
    private List<ModalClub> teams;

    public  List<ModalClub> getTeams(){
        return teams;
    }

    public void setTeams(List<ModalClub> teams){
        this.teams = teams;
    }
}
